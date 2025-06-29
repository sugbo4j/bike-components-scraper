package nz.co.sugbo4j.bike_components_scraper.scraper;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component("retailerOneScraper")
public class RetailerOneScraper extends BaseScraper {

    public RetailerOneScraper() {
        super("retailerOne", "Retailer One");
    }

    @Override
    public List<AFullBikeSet> scrape(Document document, String productUrl) {
        // TODO: Implement actual scraping logic for Retailer One
        System.out.println("Scraping Retailer One for URL: " + productUrl);
        return Collections.emptyList();
    }
}