package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.common.Material;
import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.BikeBrand;

public record Frame(
        BikeBrand brand,
        Material material,
        Suspension suspension,
        String name,
        CableRouting cableRouting,
        BottomBracket bottomBracket,
        double seatPostDiameter) {

    public static enum Suspension {
        HARDTAIL, RIGID, FULLSUSPENSION
    }

    public static enum CableRouting {
        INTERNAL, EXTERNAL
    }


}

