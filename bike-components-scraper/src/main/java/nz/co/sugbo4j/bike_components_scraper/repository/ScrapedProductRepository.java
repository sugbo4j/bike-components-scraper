package nz.co.sugbo4j.bike_components_scraper.repository;

import nz.co.sugbo4j.bike_components_scraper.model.ScrapedProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScrapedProductRepository extends MongoRepository<ScrapedProduct, String> {
    Optional<ScrapedProduct> findByRetailerIdAndProductUrl(String retailerId, String productUrl);
}