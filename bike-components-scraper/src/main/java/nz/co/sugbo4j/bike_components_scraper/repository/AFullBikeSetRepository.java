package nz.co.sugbo4j.bike_components_scraper.repository;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AFullBikeSetRepository extends MongoRepository<AFullBikeSet, String> {
    Optional<AFullBikeSet> findByRetailerIdAndProductUrl(String retailerId, String productUrl);
}