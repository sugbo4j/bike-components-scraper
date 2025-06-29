package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.model.AFullBikeSet;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.BikeBrand;
import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductItemProcessor
        implements ItemProcessor<Retailer.Product, AFullBikeSet> {

    @Override
    public AFullBikeSet process(Retailer.Product item) throws Exception {
        // TODO: Implement actual processing logic to transform raw scraped data into
        // AFullBikeSet
        // For now, create a dummy AFullBikeSet
        System.out.println("Processing product: " + item.category() + " - " + item.url());

        // Generate a random UUID for the ID
        String id = UUID.randomUUID().toString();
        String retailerId = "dummyRetailerId"; // This should come from the actual scraped data
        String productUrl = "http://dummy.url/" + item.url(); // This should come from the actual scraped data

        return new AFullBikeSet(
                id,
                retailerId,
                productUrl,
                BikeBrand.SPECIALIZED, // Dummy data
                "Mountain", // Dummy data
                "Stumpjumper", // Dummy data
                "A versatile trail bike.", // Dummy data
                "Stumpjumper", // Dummy data
                2023, // Dummy data
                new String[] { "S", "M", "L" }, // Dummy data
                null, // Frame (dummy data, needs proper mapping)
                null, // GroupSet (dummy data, needs proper mapping)
                null, // Fork (dummy data, needs proper mapping)
                null, // RearShock (dummy data, needs proper mapping)
                null, // Handlebar (dummy data, needs proper mapping)
                null, // Stem (dummy data, needs proper mapping)
                null, // Grips (dummy data, needs proper mapping)
                null, // Saddle (dummy data, needs proper mapping)
                null, // SeatPost (dummy data, needs proper mapping)
                null, // Hub[] (dummy data, needs proper mapping)
                null, // Rims (dummy data, needs proper mapping)
                null, // Tires[] (dummy data, needs proper mapping)
                null, // Rotor[] (dummy data, needs proper mapping)
                null // Pedals (dummy data, needs proper mapping)
        );
    }
}