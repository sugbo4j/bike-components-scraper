package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.ComponentBrand;

public record Fork(ComponentBrand maker, String model, String description, int travelMm, int offsetMm) {
}
