package nz.co.sugbo4j.bike_components_scraper.config;

import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer;
import nz.co.sugbo4j.bike_components_scraper.model.scrapeData.Retailer.Product;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Value;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Configuration
public class RetailerConfiguration {

    @Bean
    public List<Retailer> retailerProperties(
            @Value("${retailer.config.path:retailer-config.yaml}") String configPath) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new ClassPathResource(configPath).getInputStream()) {
            Map<String, Object> data = yaml.load(inputStream);
            List<Map<String, Object>> retailersData = (List<Map<String, Object>>) data.get("retailers");
            return retailersData.stream()
                    .map(this::mapToRetailer)
                    .toList();
        }
    }

    private Retailer mapToRetailer(Map<String, Object> retailerData) {
        var id = (String) retailerData.get("id");
        var name = (String) retailerData.get("name");
        var baseUrl = (String) retailerData.get("baseUrl");
        var scraperClass = (String) retailerData.get("scraperClass");
        var enabled = (Boolean) retailerData.get("enabled");
        var schedule = (String) retailerData.get("schedule");
        var productsData = (List<Map<String, String>>) retailerData.get("products");
        List<Product> products = null;
        if (productsData != null) {
            products = productsData.stream()
                    .map(p -> new Product(p.get("category"), p.get("url")))
                    .toList();
        }
        // Assuming scrapedAt and lastUpdated are not directly in retailer-config.yaml
        // and will be set elsewhere or are optional.
        // For now, setting them to null or Instant.EPOCH
        return new Retailer(id, name, baseUrl, scraperClass, enabled != null ? enabled : false, schedule, products,
                null, null);
    }
}