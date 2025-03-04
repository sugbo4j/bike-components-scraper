package nz.co.sugbo4j.bike_components_scraper.model;

public record BottomBracket(Type type, String standard, double width) {

    public static enum Type {
        THREADED, PRESS_FIT
    }
}
