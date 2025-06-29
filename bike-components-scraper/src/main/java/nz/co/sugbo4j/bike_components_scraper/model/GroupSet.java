package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.ComponentBrand;

public record GroupSet(
                ComponentBrand maker,
                Brakes[] brakes,
                Crank crank,
                Shifters shifters,
                Derailleur[] derailleurs,
                Cassette cassette,
                BottomBracket bottomBracket,
                Chain chain,
                Chainring chainring) {
}
