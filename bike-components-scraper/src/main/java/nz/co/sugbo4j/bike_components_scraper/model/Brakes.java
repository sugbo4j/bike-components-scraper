package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record Brakes(PartsMaker maker, String model, String description, int numPiston) {
}
