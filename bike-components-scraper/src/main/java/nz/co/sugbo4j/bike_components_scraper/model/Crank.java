package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.ComponentBrand;

public record Crank(ComponentBrand maker, String model, String description) {
}
