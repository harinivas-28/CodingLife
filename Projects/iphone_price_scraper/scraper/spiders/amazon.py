import scrapy
from database.insert import insert_price

class AmazonSpider(scrapy.Spider):
    name = 'amazon'
    allowed_domains = ['amazon.in']
    start_urls = ['https://www.amazon.in/s?k=iphone']
    
    def start_requests(self):
        # Add headers to avoid being blocked
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'
        }
        for url in self.start_urls:
            yield scrapy.Request(url=url, headers=headers, callback=self.parse)

    def parse(self, response):
        for product in response.css('.s-result-item'):
            model = product.css('h2 span::text').get()
            price = product.css('.a-price-whole::text').get()
            
            if model and price:
                # Clean price string - remove currency symbols and commas
                clean_price = price.replace('₹', '').replace(',', '').strip()
                try:
                    insert_price({
                        'model_name': model.strip(),
                        'price': clean_price,
                        'site': 'Amazon'
                    })
                except Exception as e:
                    self.logger.error(f"Error inserting data: {e}")