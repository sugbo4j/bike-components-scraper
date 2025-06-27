package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record SeatPost(PartsMaker maker, String model, String description, BottomBracket.Type type, double length, double diameter) {

    public static enum Type {
        RIGID, DROPPER
    }
}
