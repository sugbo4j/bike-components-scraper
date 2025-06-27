package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record BottomBracket(PartsMaker maker, String model, String description, Type type, String standard, double width) {

    public static enum Type {
        THREADED, PRESS_FIT
    }
}
