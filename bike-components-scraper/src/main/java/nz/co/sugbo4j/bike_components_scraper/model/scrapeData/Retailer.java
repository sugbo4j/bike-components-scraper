package nz.co.sugbo4j.bike_components_scraper.model.scrapeData;

import java.time.Instant;
import java.util.List;

public record Retailer(
                String retailerId,
                String retailerName,
                String retailerUrl,
                String scraperClass,
                boolean enabled,
                String schedule,
                List<Product> products,
                Instant scrapedAt,
                Instant lastUpdated) {

        public record Product(
                        String category,
                        String url) {
        }
}
