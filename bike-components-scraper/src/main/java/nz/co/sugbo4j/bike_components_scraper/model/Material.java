package nz.co.sugbo4j.bike_components_scraper.model;

public enum Material {
    CARBON("Carbon"), ALU("Aluminum"), STEEL("Steel"), TITANIUM("Titanium");
    private final String text;

    Material(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
