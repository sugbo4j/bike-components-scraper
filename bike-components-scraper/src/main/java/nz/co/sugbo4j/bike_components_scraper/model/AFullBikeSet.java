package nz.co.sugbo4j.bike_components_scraper.model;

import nz.co.sugbo4j.bike_components_scraper.model.manufacturer.BikeBrand;
import org.springframework.data.annotation.Id;

public record AFullBikeSet(@Id String id,
                String retailerId,
                String productUrl,
                BikeBrand brand,
                String sportCategory,
                String model,
                String description,
                String modelFamily,
                int year,
                String[] sizes,
                Frame frame,
                GroupSet groupset,
                Fork fork,
                RearShock rearShock,
                Handlebar handlebar,
                Stem stem,
                Grips grips,
                Saddle saddle,
                SeatPost seatPost,
                Hub[] hubs,
                Rims rims,
                Tires[] tires,
                Rotor[] rotors,
                Pedals pedals) {
}