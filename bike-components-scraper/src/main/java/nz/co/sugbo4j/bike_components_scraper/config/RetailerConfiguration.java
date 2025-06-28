package nz.co.sugbo4j.bike_components_scraper.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Value;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
public class RetailerConfiguration {

    @Bean
    public RetailerProperties retailerProperties(
            @Value("${retailer.config.path:retailer-config.yaml}") String configPath) throws IOException {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new ClassPathResource(configPath).getInputStream()) {
            Map<String, Object> data = yaml.load(inputStream);
            List<Map<String, Object>> retailersData = (List<Map<String, Object>>) data.get("retailers");
            List<RetailerProperties.Retailer> retailers = retailersData.stream()
                    .map(this::mapToRetailer)
                    .collect(Collectors.toList());
            return new RetailerProperties(retailers);
        }
    }

    private RetailerProperties.Retailer mapToRetailer(Map<String, Object> retailerData) {
        RetailerProperties.Retailer retailer = new RetailerProperties.Retailer();
        retailer.setId((String) retailerData.get("id"));
        retailer.setName((String) retailerData.get("name"));
        retailer.setBaseUrl((String) retailerData.get("baseUrl"));
        retailer.setScraperClass((String) retailerData.get("scraperClass"));
        retailer.setEnabled((Boolean) retailerData.get("enabled"));
        retailer.setSchedule((String) retailerData.get("schedule"));
        List<Map<String, String>> productsData = (List<Map<String, String>>) retailerData.get("products");
        if (productsData != null) {
            retailer.setProducts(productsData.stream()
                    .map(p -> new RetailerProperties.Product(p.get("category"), p.get("url")))
                    .collect(Collectors.toList()));
        }
        return retailer;
    }

    @ConfigurationProperties(prefix = "retailer")
    public static class RetailerProperties {
        private List<Retailer> retailers;

        public RetailerProperties(List<Retailer> retailers) {
            this.retailers = retailers;
        }

        public List<Retailer> getRetailers() {
            return retailers;
        }

        public void setRetailers(List<Retailer> retailers) {
            this.retailers = retailers;
        }

        public static class Retailer {
            private String id;
            private String name;
            private String baseUrl;
            private String scraperClass;
            private boolean enabled;
            private String schedule;
            private List<Product> products;

            // Getters and Setters
            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getBaseUrl() {
                return baseUrl;
            }

            public void setBaseUrl(String baseUrl) {
                this.baseUrl = baseUrl;
            }

            public String getScraperClass() {
                return scraperClass;
            }

            public void setScraperClass(String scraperClass) {
                this.scraperClass = scraperClass;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getSchedule() {
                return schedule;
            }

            public void setSchedule(String schedule) {
                this.schedule = schedule;
            }

            public List<Product> getProducts() {
                return products;
            }

            public void setProducts(List<Product> products) {
                this.products = products;
            }
        }

        public static class Product {
            private String category;
            private String url;

            public Product(String category, String url) {
                this.category = category;
                this.url = url;
            }

            // Getters
            public String getCategory() {
                return category;
            }

            public String getUrl() {
                return url;
            }
        }
    }
}