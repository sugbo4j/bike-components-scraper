# Architectural Overview: Bike Components Scraper

This document provides a comprehensive overview of the `bike-components-scraper` project's architecture, design patterns, key components, and conventions. It aims to serve as a guide for new developers to quickly understand the system's structure and facilitate seamless onboarding.

## 1. Project Purpose

The `bike-components-scraper` is a web scraping tool designed to extract bike component specifications from popular online bike stores. The collected data is then saved to MongoDB, primarily for consumption by the `BikeSpec Pro` mobile application and the `BikeSpec API`.

**Key Objectives:**

- Automate the collection of detailed bike component specifications.
- Build and maintain a comprehensive record of current mountain bike and road bike components.
- Capture detailed specifications, compatibility information, and pricing data.
- Monitor for new product releases and specification updates.

## 2. High-Level Architecture

The application is built as a Spring Boot application, leveraging modern Java (JDK 21) for its core logic. It utilizes JSoup for HTML parsing and MongoDB for persistent data storage. The architecture is designed to be modular, allowing for easy extension to support new retailers and data processing pipelines.

**Data Flow:**

```
+---------------------+     +---------------------+     +---------------------+
|  Online Retailers   | <---|   BaseScraper     | <---|  Retailer-specific  |
| (Websites)          |     | (JSoup, HTTP)       |     |    Scrapers         |
+---------------------+     +---------------------+     +---------------------+
          |                               ^
          | (Scraped Data)                |
          v                               |
+---------------------+     +---------------------+
|  ProductItemProcessor |     |  RetailerItemReader |
| (Data Normalization)| <---| (Configured Retailers)|
+---------------------+     +---------------------+
          |
          | (Processed Data: AFullBikeSet)
          v
+---------------------+
|  ProductItemWriter  |
| (MongoDB Storage)   |
+---------------------+
          |
          | (Stored Data)
          v
+---------------------+
|      MongoDB        |
| (AFullBikeSet Collection)|
+---------------------+
```

The data flows from retailers, through the scraping and processing pipeline, and is ultimately stored in MongoDB as `AFullBikeSet` documents.

## 3. Module Organization

The project follows a standard Maven project structure, with source code organized into logical packages reflecting their responsibilities.

```
bike-components-scraper/
├───src/
│   ├───main/
│   │   ├───java/
│   │   │   └───nz/
│   │   │       └───co/
│   │   │           └───sugbo4j/
│   │   │               └───bike_components_scraper/
│   │   │                   ├───Application.java             // Main Spring Boot entry point
│   │   │                   ├───batch/                       // Spring Batch components
│   │   │                   │   ├───ProductItemProcessor.java
│   │   │                   │   ├───ProductItemWriter.java
│   │   │                   │   ├───RetailerItemReader.java
│   │   │                   │   └───ScrapingJobScheduler.java
│   │   │                   ├───config/                      // Spring Configuration classes
│   │   │                   │   ├───BatchConfiguration.java
│   │   │                   │   ├───MongoConfiguration.java
│   │   │                   │   └───RetailerConfiguration.java
│   │   │                   ├───metrics/                     // Metrics and monitoring
│   │   │                   │   └───ScrapingMetricsEndpoint.java
│   │   │                   ├───model/                       // Data models (Java Records)
│   │   │                   │   ├───... (Bike component models)
│   │   │                   │   ├───common/
│   │   │                   │   ├───manufacturer/
│   │   │                   │   └───scrapeData/
│   │   │                   │       └───Retailer.java        // Record for retailer config
│   │   │                   ├───repository/                  // Spring Data MongoDB repositories
│   │   │                   │   └───AFullBikeSetRepository.java
│   │   │                   └───scraper/                     // Web scraping logic
│   │   │                       ├───BaseScraper.java
│   │   │                       └───RetailerOneScraper.java
│   │   └───resources/               // Application resources (YAML configs, images)
│   │       ├───application.yml
│   │       ├───retailer-config.yaml
│   │       └───diagrams/
│   └───test/                        // Unit and integration tests
```

## 4. Key Components

- **`Application.java`**: The main entry point for the Spring Boot application.
- **`batch/`**: Contains Spring Batch components responsible for the scraping job.
  - `RetailerItemReader`: Reads configured retailers and their products to be scraped. It consumes the `List<Retailer>` bean.
  - `ProductItemProcessor`: Processes and normalizes the scraped data from a `Retailer.Product` into an `AFullBikeSet` model.
  - `ProductItemWriter`: Writes the processed `AFullBikeSet` data to MongoDB.
  - `ScrapingJobScheduler`: Schedules and orchestrates the scraping jobs based on the cron expressions in the retailer configuration.
- **`config/`**: Houses Spring configuration classes.
  - `BatchConfiguration`: Configures Spring Batch jobs and steps, defining the reader, processor, and writer.
  - `MongoConfiguration`: Configures the MongoDB connection.
  - `RetailerConfiguration`: Loads retailer-specific scraping configurations from `retailer-config.yaml`. It produces a `List<Retailer>` bean, using Java Records for immutable and concise configuration representation.
- **`model/`**: Defines the data structures using Java Records for immutability. This includes various component types (e.g., `Fork`, `Crank`, `WheelSize`), common enums (`BikeSide`, `Material`), manufacturer details, and the main `AFullBikeSet` aggregate model.
- **`repository/`**: Contains Spring Data MongoDB repositories. `AFullBikeSetRepository` provides an abstraction layer for database operations on `AFullBikeSet` entities.
- **`scraper/`**: Implements the core web scraping logic.
  - `BaseScraper`: Provides common scraping functionalities and utilities (e.g., using JSoup).
  - `RetailerOneScraper`: An example of a retailer-specific scraper implementation, extending `BaseScraper`. New retailers will have their own scraper classes here.
- **`resources/`**:
  - `application.yml`: Main Spring Boot configuration.
  - `retailer-config.yaml`: Configuration for different retailers, specifying URLs, scraper class, schedule, and product categories.

## 5. Design Patterns

- **Spring Batch**: Utilized for robust and scalable batch processing of scraping jobs, handling reading, processing, and writing data in chunks.
- **Repository Pattern**: Implemented via Spring Data MongoDB, abstracting data access logic and promoting a clean separation of concerns.
- **Strategy Pattern**: Evident in the `scraper` package, where `BaseScraper` defines a common interface for scraping, and concrete `RetailerXScraper` classes provide specific implementations for different retailers.

## 6. Dependencies

The project relies on the following key technologies and libraries:

- **Java 21 or higher**: The primary programming language.
- **Maven 3 or higher**: Build automation tool.
- **Spring Boot**: Framework for building stand-alone, production-grade Spring applications.
- **Spring Batch**: Framework for robust batch processing.
- **Spring Data MongoDB**: Simplifies data access to MongoDB.
- **JSoup**: Java library for working with real-world HTML.
- **MongoDB**: NoSQL database for storing scraped product data.

## 7. Entry Points

The primary entry point for the application is the `main` method within `nz.co.sugbo4j.bike_components_scraper.Application.java`. When the Spring Boot application starts, it initializes the Spring context, configures the batch jobs, and schedules the scraping process via `ScrapingJobScheduler`.

## 8. Critical Workflows

1.  **Application Startup**: Spring Boot initializes, loads configurations (including the `List<Retailer>` from `retailer-config.yaml`), and sets up the MongoDB connection.
2.  **Job Scheduling**: The `ScrapingJobScheduler` iterates through the enabled retailers and schedules a scraping job for each one based on its cron schedule.
3.  **Retailer Data Reading**: The `RetailerItemReader` provides the products (`Retailer.Product`) for the currently executing job.
4.  **Web Scraping**: For each product, the appropriate `RetailerXScraper` (e.g., `RetailerOneScraper`) uses JSoup to connect to the retailer's website, parse the HTML, and extract relevant product specifications.
5.  **Data Processing**: The `ProductItemProcessor` normalizes the raw scraped data into a consistent `AFullBikeSet` model, handling data cleaning, validation, and transformation.
6.  **Data Storage**: The `ProductItemWriter` persists the normalized `AFullBikeSet` objects into the MongoDB database.
7.  **Monitoring and Logging**: Throughout the process, logs are generated for debugging, performance monitoring, and error tracking.

## 9. Scalability and Maintainability

- **Modularity**: The clear separation of concerns (e.g., scraping logic, data models, batch processing) makes the codebase easier to understand, maintain, and extend.
- **Configurable Retailers**: New retailers can be added by simply updating `retailer-config.yaml` and implementing a new `BaseScraper` extension, minimizing code changes.
- **Spring Batch**: Provides built-in features for restartability, chunk-based processing, and parallelization, contributing to the scalability of the scraping jobs.
- **MongoDB**: A scalable NoSQL database well-suited for handling large volumes of semi-structured data.
- **Automated Scheduling**: Ensures consistent and hands-off operation.

## 10. Domain-Specific Decisions

- **Detailed Product Models**: The `model` package contains a rich hierarchy of bike component classes (e.g., `Fork`, `Crank`, `WheelSize`), reflecting the specific attributes and variations relevant to bike components. This detailed modeling supports comprehensive data capture and future compatibility analysis.
- **Retailer-Specific Scraping**: Acknowledges that each online retailer may have a unique website structure, necessitating specific scraper implementations for accurate data extraction.
- **Data Normalization**: Emphasizes the importance of normalizing data from disparate sources into a consistent format (`AFullBikeSet`) to ensure data quality and usability for downstream applications like BikeSpec Pro.
