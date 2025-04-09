import scrapy
from database.insert import insert_price

class FlipkartSpider(scrapy.Spider):
    name = 'flipkart'
    allowed_domains = ['flipkart.com']
    start_urls = ['https://www.flipkart.com/search?q=iphone']

    def start_requests(self):
        headers = {
            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36'
        }
        for url in self.start_urls:
            yield scrapy.Request(url=url, headers=headers, callback=self.parse)

    def parse(self, response):
        for product in response.css('div._1AtVbE'):  # Updated container class
            model = product.css('div._4rR01T::text').get()  # Selector for model name
            price = product.css('div._30jeq3._1_WHN1::text').get()  # Updated selector for price

            if model and price:
                # Clean price string - remove currency symbols and commas
                clean_price = price.replace('₹', '').replace(',', '').strip()
                try:
                    insert_price({
                        'model_name': model.strip(),
                        'price': clean_price,
                        'site': 'Flipkart'
                    })
                except Exception as e:
                    self.logger.error(f"Error inserting data: {e}")