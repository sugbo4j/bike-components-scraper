package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.PartsMaker;

public record GroupSet(
        PartsMaker maker,
        Brakes brakes,
        Crank crank,
        Shifters shifters,
        FrontDerailleur frontDerailleur,
        RearDerailleur rearDerailleur,
        Cassette cassette,
        BottomBracket bottomBracket,
        Chain chain,
        Chainring chainring) {
}
