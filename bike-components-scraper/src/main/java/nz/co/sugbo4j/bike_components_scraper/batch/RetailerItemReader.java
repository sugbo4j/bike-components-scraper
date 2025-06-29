package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer;
import nz.co.sugbo4j.bike_components_scraper.scraper.BaseScraper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Component
public class RetailerItemReader implements ItemReader<Retailer.Product> {

    private final ApplicationContext applicationContext;
    private final List<Retailer> retailers;
    private Queue<Retailer.Product> productQueue;
    private BaseScraper currentScraper;
    private String currentBaseUrl;

    @Autowired
    public RetailerItemReader(ApplicationContext applicationContext, List<Retailer> retailers) {
        this.applicationContext = applicationContext;
        this.retailers = retailers;
        initializeProductQueue();
    }

    private void initializeProductQueue() {
        productQueue = new ConcurrentLinkedQueue<>();
        retailers.stream()
                .filter(Retailer::enabled)
                .forEach(retailer -> {
                    try {
                        Class<?> scraperClass = Class.forName(retailer.scraperClass());
                        currentScraper = (BaseScraper) applicationContext.getBean(scraperClass);
                        currentBaseUrl = retailer.retailerUrl();
                        retailer.products().forEach(productQueue::add);
                    } catch (ClassNotFoundException e) {
                        System.err.println("Scraper class not found: " + retailer.scraperClass());
                    }
                });
    }

    @Override
    public Retailer.Product read() throws Exception {
        if (productQueue.isEmpty()) {
            return null; // No more products to scrape
        }

        Retailer.Product product = productQueue.poll();
        if (product != null) {
            String fullUrl = currentBaseUrl + product.url();
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