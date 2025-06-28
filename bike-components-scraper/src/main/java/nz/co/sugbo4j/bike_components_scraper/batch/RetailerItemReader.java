package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.config.RetailerConfiguration;
import nz.co.sugbo4j.bike_components_scraper.scraper.BaseScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class RetailerItemReader implements ItemReader<RetailerConfiguration.RetailerProperties.Product> {

    private final ApplicationContext applicationContext;
    private final RetailerConfiguration.RetailerProperties retailerProperties;
    private Queue<RetailerConfiguration.RetailerProperties.Product> productQueue;
    private BaseScraper currentScraper;
    private String currentBaseUrl;

    @Autowired
    public RetailerItemReader(ApplicationContext applicationContext,
            RetailerConfiguration.RetailerProperties retailerProperties) {
        this.applicationContext = applicationContext;
        this.retailerProperties = retailerProperties;
        initializeProductQueue();
    }

    private void initializeProductQueue() {
        productQueue = new ConcurrentLinkedQueue<>();
        retailerProperties.getRetailers().stream()
                .filter(RetailerConfiguration.RetailerProperties.Retailer::isEnabled)
                .forEach(retailer -> {
                    try {
                        Class<?> scraperClass = Class.forName(retailer.getScraperClass());
                        currentScraper = (BaseScraper) applicationContext.getBean(scraperClass);
                        currentBaseUrl = retailer.getBaseUrl();
                        retailer.getProducts().forEach(product -> productQueue.add(product));
                    } catch (ClassNotFoundException e) {
                        System.err.println("Scraper class not found: " + retailer.getScraperClass());
                    }
                });
    }

    @Override
    public RetailerConfiguration.RetailerProperties.Product read() throws Exception {
        if (productQueue.isEmpty()) {
            return null; // No more products to scrape
        }

        RetailerConfiguration.RetailerProperties.Product product = productQueue.poll();
        if (product != null) {
            String fullUrl = currentBaseUrl + product.getUrl();
            try {
                Document document = Jsoup.connect(fullUrl).get();
                // Here, we would typically pass the document to the currentScraper
                // For now, we'll just log and return the product to simulate reading.
                System.out.println("Successfully fetched: " + fullUrl);
            } catch (IOException e) {
                System.err.println("Failed to fetch " + fullUrl + ": " + e.getMessage());
                // Optionally re-add to queue for retry or handle error
            }
        }
        return product;
    }
}