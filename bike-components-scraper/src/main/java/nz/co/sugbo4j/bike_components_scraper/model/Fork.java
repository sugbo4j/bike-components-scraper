package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record Fork(PartsMaker maker, String model, String description, int travelMm, int offsetMm) {
}
