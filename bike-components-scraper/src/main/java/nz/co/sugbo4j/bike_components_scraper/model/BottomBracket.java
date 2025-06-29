package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.ComponentBrand;

public record BottomBracket(ComponentBrand maker, String model, String description, Type type, String standard,
        double width) {

    public static enum Type {
        THREADED, PRESS_FIT
    }
}
