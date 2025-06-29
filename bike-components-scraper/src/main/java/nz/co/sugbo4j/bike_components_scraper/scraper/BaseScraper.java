package nz.co.sugbo4j.bike_components_scraper.scraper;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import org.jsoup.nodes.Document;

import java.util.List;

public abstract class BaseScraper {

    protected String retailerId;
    protected String retailerName;

    public BaseScraper(String retailerId, String retailerName) {
        this.retailerId = retailerId;
        this.retailerName = retailerName;
    }

    public abstract List<AFullBikeSet> scrape(Document document, String productUrl);

    public String getRetailerId() {
        return retailerId;
    }

    public String getRetailerName() {
        return retailerName;
    }
}