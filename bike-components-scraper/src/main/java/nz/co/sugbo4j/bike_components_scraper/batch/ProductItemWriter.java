package nz.co.sugbo4j.bike_components_scraper.batch;

import nz.co.sugbo4j.bike_components_scraper.model.ScrapedProduct;
import nz.co.sugbo4j.bike_components_scraper.repository.ScrapedProductRepository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductItemWriter implements ItemWriter<ScrapedProduct> {

    private final ScrapedProductRepository scrapedProductRepository;

    @Autowired
    public ProductItemWriter(ScrapedProductRepository scrapedProductRepository) {
        this.scrapedProductRepository = scrapedProductRepository;
    }

    @Override
    public void write(Chunk<? extends ScrapedProduct> chunk) throws Exception {
        for (ScrapedProduct product : chunk.getItems()) {
            Optional<ScrapedProduct> existingProduct = scrapedProductRepository.findByRetailerIdAndProductUrl(
                    product.retailerId(), product.productUrl());

            if (existingProduct.isPresent()) {
                // Update existing document
                ScrapedProduct updatedProduct = existingProduct.get();
                // Copy relevant fields from new product to existing one
                updatedProduct = new ScrapedProduct(
                        updatedProduct.id(), // Keep existing ID
                        product.retailerId(),
                        product.retailerName(),
                        product.productUrl(),
                        product.productName(),
                        product.brand(),
                        product.category(),
                        product.price(),
                        product.currency(),
                        product.imageUrl(),
                        product.description(),
                        product.scrapedDate(),
                        product.available());
                scrapedProductRepository.save(updatedProduct);
                System.out.println("Updated product: " + updatedProduct.productName());
            } else {
                // Save new document
                scrapedProductRepository.save(product);
                System.out.println("Saved new product: " + product.productName());
            }
        }
    }
}