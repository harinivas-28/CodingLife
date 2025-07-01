package Coding.java;
/*
You are building an E-Commerce Product Insights Engine for a marketplace like
Amazon or Flipkart. The platform stores information about various products,
their pricing history, and user ratings.

Your job is to:

    1. Accept data for multiple products.

    2. Each product has:
        Multiple price entries (date + price)
        Multiple ratings (user + stars out of 5)

    3. Calculate:
        Average price of the product
        Price volatility score: Standard deviation of prices
        Average rating

    4. Classify products into Insight Tiers:
        Stable & Loved: Volatility < 100 and Rating ≥ 4.0
        Unstable but Popular: Volatility ≥ 100 and Rating ≥ 4.0
        Unstable & Poorly Rated: Volatility ≥ 100 and Rating < 4.0
        Stable but Low-Rated: Volatility < 100 and Rating < 4.0

Sample Input:
-------------
2               // Number of products
EchoDot         // ProductName
3               // Number of price entries
2024-06-01 3499 // priceDate priceAmount
2024-06-10 3299
2024-06-15 3599
2               // Number of ratings
Alice 5         // userName stars
Bob 4
OldTV           // ProductName
4               // Number of price entries
2024-05-01 9999 // priceDate priceAmount
2024-05-10 10999
2024-05-15 11999
2024-05-20 8999
3               // Number of ratings
Charlie 2       // userName stars
Diana 3
Eve 1

Sample Output:
--------------
Product: EchoDot, AvgPrice: 3465.7, Volatility: 124.7, AvgRating: 4.5, Tier: Unstable but Popular
Product: OldTV, AvgPrice: 10499.0, Volatility: 1118.0, AvgRating: 2.0, Tier: Unstable & Poorly Rated

 */
import java.util.*;

public class Day71P3Design {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int m = Integer.parseInt(sc.nextLine());

            List<PriceEntry> prices = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                String[] parts = sc.nextLine().split(" ");
                prices.add(new PriceEntry(parts[0], Double.parseDouble(parts[1])));
            }

            int k = Integer.parseInt(sc.nextLine());
            List<Rating> ratings = new ArrayList<>();
            for (int j = 0; j < k; j++) {
                String[] parts = sc.nextLine().split(" ");
                ratings.add(new Rating(parts[0], Integer.parseInt(parts[1])));
            }

            products.add(new Product(name, prices, ratings));
        }

        InsightEngine engine = new InsightEngineImpl();
        System.out.println("=== Product Insights Summary ===");
        for (Product p : products) {
            ProductInsight insight = engine.analyze(p);
            System.out.println(insight);
        }
    }

    static class PriceEntry {
        String date;
        double amount;
        public PriceEntry(String date, double amount) {
            this.date = date;
            this.amount = amount;
        }
    }

    static class Rating {
        String username;
        int stars;
        public Rating(String username, int stars) {
            this.username = username;
            this.stars = stars;
        }
    }

    static class Product {
        String name;
        List<PriceEntry> prices;
        List<Rating> ratings;
        public Product(String name, List<PriceEntry> prices, List<Rating> ratings) {
            this.name = name;
            this.prices = prices;
            this.ratings = ratings;
        }
    }

    static class ProductInsight {
        Product product;
        double avgPrice, volatility, avgRating;
        String insightTier;

        public ProductInsight(Product product, double avgPrice, double volatility, double avgRating, String insightTier) {
            this.product = product;
            this.avgPrice = avgPrice;
            this.volatility = volatility;
            this.avgRating = avgRating;
            this.insightTier = insightTier;
        }

        public String toString() {
            return "Product: " + product.name +
                    ", AvgPrice: " + String.format("%.1f", avgPrice) +
                    ", Volatility: " + String.format("%.1f", volatility) +
                    ", AvgRating: " + String.format("%.1f", avgRating) +
                    ", Tier: " + insightTier;
        }
    }

    interface InsightEngine {
        ProductInsight analyze(Product p);
    }

    static class InsightEngineImpl implements InsightEngine {
        public ProductInsight analyze(Product p) {
            // Avg Price
            double priceSum = 0;
            for (PriceEntry entry : p.prices) {
                priceSum += entry.amount;
            }
            double avgPrice = p.prices.isEmpty() ? 0 : priceSum / p.prices.size();

            // Volatility (Standard Deviation)
            double sqDiffSum = 0;
            for (PriceEntry entry : p.prices) {
                sqDiffSum += Math.pow(entry.amount - avgPrice, 2);
            }
            double variance = p.prices.isEmpty() ? 0 : sqDiffSum / p.prices.size();
            double volatility = Math.sqrt(variance);

            // Avg Rating
            double ratingSum = 0;
            for (Rating r : p.ratings) {
                ratingSum += r.stars;
            }
            double avgRating = p.ratings.isEmpty() ? 0 : ratingSum / p.ratings.size();

            // Tier
            String tier;
            if (volatility < 100 && avgRating >= 4.0) {
                tier = "Stable & Loved";
            } else if (volatility >= 100 && avgRating >= 4.0) {
                tier = "Unstable but Popular";
            } else if (volatility >= 100 && avgRating < 4.0) {
                tier = "Unstable & Poorly Rated";
            } else {
                tier = "Stable but Low-Rated";
            }

            return new ProductInsight(p, avgPrice, volatility, avgRating, tier);
        }
    }
}
