package nz.co.sugbo4j.bike_components_scraper.model.scrapeData;

import java.time.Instant;

public record Retailer(
        String retailerId,
        String retailerName,
        String retailerUrl,
        Instant scrapedAt,
        Instant lastUpdated) {
}
