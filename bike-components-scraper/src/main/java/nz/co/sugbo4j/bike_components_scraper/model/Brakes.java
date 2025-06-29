package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.common.BikeSide;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.ComponentBrand;

public record Brakes(ComponentBrand maker, String model, String description, int numPiston, BikeSide side) {
}
