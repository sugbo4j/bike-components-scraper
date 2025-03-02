package nz.co.sugbo4j.bike_components_scraper.model;

import java.util.Arrays;
import java.util.Optional;

public enum BikeBrand {

    ALCHEMY("Alchemy", "https://alchemybikes.com"),
    ARI("Ari","https://aribikes.com"),
    ATHERTON("Atherton","https://www.athertonbikes.com"),
    AVENTON("Aventon","https://www.aventon.com"),
    BAKCOU("Bakcou"), //ebike only
    BANSHEE("Banshee "),
    BERGAMONT("Bergamont"), //mostly ebike
    BIANCHI("Bianchi"),
    BIRD("Bird"),
    BMC("BMC"),
    BREEZER("Breezer"), //mostly road bike
    CANFIELD("Canfield"),
    CANNONDALE("Cannondale"),
    CANYON("Canyon"),
    CERVELO("Cervelo"), //mostly road bike
    CO_OP_CYCLES("Co-op Cycles"),      // Adjusted "CO-OP CYCLES" for valid syntax
    COMMENCAL("Commencal"),
    CORRATEC("Corratec"),
    CUBE("Cube"),
    DEVINCI("Devinci"),
    DIAMONDBACK("Diamondback"),
    E_LUX("E-Lux"), //mostly ebike
    ELLSWORTH("Ellsworth"),
    EVIL("Evil"),
    FELT("Felt"), //mostly road bike
    FLYER("Flyer"), //ebike only
    FUJI("Fuji"),
    GHOST("Ghost"),
    GIANT("Giant"),
    GT("GT"),
    GUERCIOTTI("Guerciotti"), //mostly road bike
    HARO("Haro"),
    HILAND("Hiland"),
    HIMIWAY("Himiway"), //ebike only
    IBIS("Ibis"),
    JAMIS("Jamis"),
    JULIANA("Juliana"),
    KESTREL("Kestrel", "https://www.kestrelbicycles.com"), //road only
    KHS("KHS", "https://khsbicycles.com"),
    KONA("Kona", "https://www.konaworld.com"),
    KROSS("Kross", "https://kross-europe.eu"),
    KTM("KTM", "https://www.ktm-bikes.at"),
    LAPIERRE("LAPIERRE", "https://www.lapierrebikes.com"),          // Capitalized consistently
    MARIN("Marin", "https://www.marinbikes.com"),
    MERIDA("Merida", "https://www.merida-bikes.com/en"),
    MONGOOSE("mongoose", "https://www.mongoose.com"),
    MOOTS("Moots", "https://moots.com"),
    NINER("Niner", "https://www.ninerbikes.com"),
    NORCO("Norco", "https://www.norco.com"),
    OGGI("OGGI", "https://oggibikes.com.br"),
    ON_ONE("On-One", "https://planetx.co.uk/collections/on-one-bikes"),            // Adjusted "ON-ONE" for valid syntax
    ORANGE("Orange", "https://www.orangebikes.com"),
    ORBEA("Orbea", "https://www.orbea.com"),
    PIVOT("Pivot","https://www.pivotcycles.com/en"),
    POLYGON("Polygon","https://www.polygonbikes.com"),
    RALEIGH("Raleigh","https://www.raleigh.co.uk/gb/en"),
    REVEL("Revel","https://revelbikes.com"),
    ROCKY_MOUNTAIN("Rocky Mountain","https://bikes.com"),    // Adjusted "ROCKY MOUNTAIN" for valid syntax
    ROSE("Rose","https://www.rosebikes.com"),
    SALSA("Salsa","https://www.salsacycles.com"),
    SANTA_CRUZ("Santa Cruz","https://www.santacruzbicycles.com"),        // Adjusted "SANTA CRUZ" for valid syntax
    SCOTT("SCOTT","https://www.scott-sports.com"),
    SPECIALIZED("Specialized","https://www.specialized.com"),
    SPOT("Spot","https://spotbikes.com"),
    SURFACES604("Surface 604","https://surface604bikes.com"),       // ebike only
    SURLY("Surly","https://surlybikes.com"),
    TITUS("Titus","https://planetx.co.uk/collections/titus-bikes"),
    TRANSITION("Transition","https://www.transitionbikes.com"),
    TREK("Trek","https://www.trekbikes.com/us/en_US"),
    TURNER("Turner","https://turnerbikes.com"),
    UNIVEGA("Univega","https://www.univega-usa.com"),
    VITUS("Vitus","https://vitusbikes.com"),
    //WEIZE(""), //amazon/ebay only bike
    WHYTE("Whyte","https://whytebikes.com"),
    WILIER("Welier","https://www.wilier.com"),
    YETI("Yeti","https://yeticycles.com"),
    YT_INDUSTRIES("YT" ,"https://www.yt-industries.com");      // Adjusted "YT INDUSTRIES" for valid syntax

    private final String name;
    private final String url;

    BikeBrand(String name) {
        this.name = name;
        this.url = "";
    }

    BikeBrand(String name, String official_url) {
        this.name = name;
        this.url = official_url;
    }

    /**
     * Brands common name used by major retailers/dealers
     *
     * @return common name
     */
    public String getName() {
        return name;
    }

    /**
     * The Brand official website
     *
     * @return official website url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Helper method to convert a string to the corresponding BikeBrand enum.
     *
     * @param name The string representation of the brand (e.g., "Santa Cruz").
     * @return The matching BikeBrand enum, or Optional.empty() if no match is found.
     */
    public static Optional<BikeBrand> fromString(String name) {
        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }
        return Arrays.stream(values()).filter(b -> b.name.equalsIgnoreCase(name.trim())).findFirst();
    }
}
