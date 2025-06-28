package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.common.BikeSide;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record Derailleur(PartsMaker maker, String model, String description, BikeSide side) {
}
