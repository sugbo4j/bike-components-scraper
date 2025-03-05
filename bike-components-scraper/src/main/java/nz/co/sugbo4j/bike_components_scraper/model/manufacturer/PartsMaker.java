package nz.co.sugbo4j.bike_components_scraper.model.manufacturer;

public enum PartsMaker {
    FOX("fox", "url"),
    ROCK_SHOX("Rock Shox", "url"),
    SHIMANO("Shimano", "url"),
    SRAM("Sram", "url"),
    TEKTRO("Tektro", "url");;

    private final String text;
    private final String url;

    PartsMaker(String text, String url) {
        this.url = url;
        this.text = text;
    }
}
