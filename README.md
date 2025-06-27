# Bike components Scraper

A web scraping tool that extracts bike component specifications from popular online bike stores and saves the data to MongoDB for use in the BikeSpec Pro mobile application.

## 🔍 About

Bike components Scraper automates the collection of detailed bike component specifications from various online retailers. It's designed to build and maintain a comprehensive database of current mountain bike and road bike components, including detailed specifications, compatibility information, and pricing data.

## 🚲 Features

### Data Collection

- Scrapes component specifications from major online bike retailers
- Extracts detailed technical specifications in a structured format
- Captures images, pricing, and availability information
- Monitors for new product releases and specification updates

### Data Processing

- Normalizes data from different sources into a consistent format
- Identifies and resolves conflicting specification information
- Extracts compatibility data from product descriptions
- Generates unique identifiers for components across different retailers

### Storage & Integration

- Stores all data in a database
- Creates relationships between compatible components
- Maintains historical pricing data
- Prepares data for consumption by the BikeSpec Pro mobile app

### Scheduling & Monitoring

- Automated daily/weekly scraping schedule
- Rate limiting to respect website terms of service
- Error handling and recovery mechanisms
- Logging system for debugging and performance monitoring
- Email notifications for scraping failures or detected website changes

## 🛠️ Technical Implementation

### Architecture

- Java-based command line application
- JSoup library for HTML parsing
- Database for data storage
- Configurable scraping profiles for different retailers

### Key Components

- Retailer-specific scraper implementations
- Data normalization pipeline
- Database connection and schema management
- Scheduler and job management system

## 📊 Supported Retailers

- Example Bikes
- Component World
- BikePartsPlus
- MountainGearCo
- (More retailers to be added)

## 🗓️ Project Status

This project works alongside the BikeSpec Pro mobile application. Current status:

1. Core scraping engine - In Progress
2. Data normalization pipeline - Planned
3. Database integration - Planned
4. Scheduling system - Planned
5. Retailer-specific scrapers - Ongoing Addition

## ⚙️ Requirements

- Java 21 or higher
- Maven 3 or higher

## 🚀 Getting Started

### Installation

```bash
git clone https://github.com/sugbo4j/bike-components-scraper.git
cd bike-components-scraper
mvn clean install
```

### Running the Scraper

```bash
java -jar target/bike-components-scraper-1.0.0.jar
```

## ⚠️ Legal Note

This tool is designed for personal and educational use only. Always ensure your scraping activities comply with each website's terms of service and robots.txt directives. Set appropriate delays between requests to minimize server impact.

## 🤝 Contributing

Contributions are welcome, especially for adding support for new retailers or improving data extraction. Please submit a PR with a clear description of your changes.

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🔗 Related Projects

- [BikeSpec Pro](https://github.com/sugbo4j/bikeSpec-app) - Mobile application that uses the data collected by this scraper
- [BikeSpec API](https://github.com/sugbo4j/bikeSpec-api) - A RESTful API service that provides access to the comprehensive bike component database and compatibility engine
