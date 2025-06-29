package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import nz.co.sugbo4j.bike_components_scraper.repository.AFullBikeSetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductItemWriter implements ItemWriter<AFullBikeSet> {

    private static final Logger logger = LoggerFactory.getLogger(ProductItemWriter.class);

    private final AFullBikeSetRepository aFullBikeSetRepository;

    @Autowired
    public ProductItemWriter(AFullBikeSetRepository aFullBikeSetRepository) {
        this.aFullBikeSetRepository = aFullBikeSetRepository;
    }

    @Override
    public void write(Chunk<? extends AFullBikeSet> chunk) throws Exception {
        for (AFullBikeSet bikeSet : chunk.getItems()) {
            Optional<AFullBikeSet> existingBikeSet = aFullBikeSetRepository.findByRetailerIdAndProductUrl(
                    bikeSet.retailerId(), bikeSet.productUrl());

            if (existingBikeSet.isPresent()) {
                // Update existing document
                AFullBikeSet updatedBikeSet = existingBikeSet.get();
                // For a record, we need to create a new instance with updated fields.
                // Assuming we want to update all fields from the new bikeSet except the ID.
                updatedBikeSet = new AFullBikeSet(
                        updatedBikeSet.id(), // Keep existing ID
                        bikeSet.retailerId(),
                        bikeSet.productUrl(),
                        bikeSet.brand(),
                        bikeSet.sportCategory(),
                        bikeSet.model(),
                        bikeSet.description(),
                        bikeSet.modelFamily(),
                        bikeSet.year(),
                        bikeSet.sizes(),
                        bikeSet.frame(),
                        bikeSet.groupset(),
                        bikeSet.fork(),
                        bikeSet.rearShock(),
                        bikeSet.handlebar(),
                        bikeSet.stem(),
                        bikeSet.grips(),
                        bikeSet.saddle(),
                        bikeSet.seatPost(),
                        bikeSet.hubs(),
                        bikeSet.rims(),
                        bikeSet.tires(),
                        bikeSet.rotors(),
                        bikeSet.pedals());
                aFullBikeSetRepository.save(updatedBikeSet);
                logger.info("Updated AFullBikeSet: {}", updatedBikeSet.model());
            } else {
                // Save new document
                aFullBikeSetRepository.save(bikeSet);
                logger.info("Saved new AFullBikeSet: {}", bikeSet.model());
            }
        }
    }
}