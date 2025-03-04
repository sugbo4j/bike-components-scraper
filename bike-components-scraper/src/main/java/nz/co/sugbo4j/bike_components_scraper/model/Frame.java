package nz.co.sugbo4j.bike_components_scraper.model;

public record Frame(BikeBrand brand, Material material, Suspension suspension, String name, CableRouting cableRouting) {
    public static enum Suspension {
        HARDTAIL, RIGID, FULLSUSPENSION
    }

    public static enum CableRouting {
        INTERNAL, EXTERNAL
    }

}

