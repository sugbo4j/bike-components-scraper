package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.common.BikeSide;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record Rotor(PartsMaker maker, String model, String description, int diameterMm, int numBolts, BikeSide side) {
}
