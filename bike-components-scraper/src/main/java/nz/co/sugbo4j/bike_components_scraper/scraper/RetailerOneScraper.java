package nz.co.sugbo4j.bike_components_scraper.scraper;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component("retailerOneScraper")
public class RetailerOneScraper extends BaseScraper {

    private static final Logger logger = LoggerFactory.getLogger(RetailerOneScraper.class);

    public RetailerOneScraper() {
        super("retailerOne", "Retailer One");
    }

    @Override
    public List<AFullBikeSet> scrape(Document document, String productUrl) {
        // TODO: Implement actual scraping logic for Retailer One
        logger.info("Scraping Retailer One for URL: {}", productUrl);
        return Collections.emptyList();
    }
}