package nz.co.sugbo4j.bike_components_scraper.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "nz.co.sugbo4j.bike_components_scraper.repository")
public class MongoConfiguration {
    // Spring Boot auto-configures MongoTemplate and MongoClient based on
    // application.yml
    // No explicit beans needed here unless custom configuration is required.
}