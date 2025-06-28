package nz.co.sugbo4j.bike_components_scraper.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document(collection = "scrapedProducts")
public record ScrapedProduct(
        @Id String id,
        String retailerId,
        String retailerName,
        String productUrl,
        String productName,
        String brand,
        String category,
        BigDecimal price,
        String currency,
        String imageUrl,
        String description,
        LocalDateTime scrapedDate,
        boolean available) {
}