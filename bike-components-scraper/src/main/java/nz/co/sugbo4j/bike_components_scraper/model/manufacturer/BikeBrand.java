package nz.co.sugbo4j.bike_components_scraper.model.manufacturer;

import java.util.Arrays;
import java.util.Optional;

public enum BikeBrand {

    ALCHEMY("Alchemy", "https://alchemybikes.com"),
    ADDMOTOR("Addmotor", "https://addmotor.com"),
    AEGIS("Aegis", "https://aegisbicycles.com"),
    AIRBORNE("Airborne", "https://airbornebicycles.com"),
    AIRDROP("Airdrop", "https://www.airdropbikes.com"),
    ALUTECH("Alutech", "https://alutech-cycles.com"),
    AMEGO("Amego", "https://www.amegobikes.com"),
    AMFLOW("Amflow", "https://amflowbikes.com"),
    ANCHEER("Ancheer", "https://www.ancheer.shop"),
    ANTIDOTE("Antidote", "https://antidotebikes.com"),
    APOLLO("Apollo", "https://www.apollobikes.com"),
    ARC8("Arc8", "https://www.arc8bicycles.com"),
    ARGON_18("Argon 18", "https://www.argon18.com"),
    ARI("Ari", "https://aribikes.com"),
    ATHERTON("Atherton", "https://www.athertonbikes.com"),
    AURAI("Aurai", "https://www.aurai-bike.com"),
    AVANTI("Avanti", "https://www.avantibikes.com"),
    // Removed AVENTON - primarily e-bikes
    // Removed BAKCOU - ebike only
    BANSHEE("Banshee", "https://www.bansheebikes.com"),
    BARRACUDA("Barracuda", "https://www.barracudabikes.com"),
    BASIS("Basis", "https://basisbikes.com"),
    BASSO("Basso", "https://www.bassobikes.com"),
    BATCH_BICYCLES("Batch Bicycles", "https://batchbicycles.com"),
    BATRIBIKE("Batribike", "https://batribike.com"),
    BENNO("Benno", "https://www.bennobikes.com"),
    BERGAMONT("Bergamont", "https://www.bergamont.com"), // mostly ebike (not removed as not exclusively ebike)
    BERRIA("Berria", "https://www.berriabikes.com"),
    BH("BH", "https://www.bhbikes.com"),
    BIANCHI("Bianchi", "https://www.bianchi.com"),
    // Removed BIKTRIX - e-bike specialist
    BIRD("Bird", "https://www.bird.bike"),
    // Removed BLIX - e-bike specialist
    // Removed BLUEJAY - primarily e-bikes
    BMC("BMC", "https://www.bmc-switzerland.com"),
    BOARDMAN("Boardman", "https://www.boardmanbikes.com"),
    BOLD("Bold", "https://www.boldcycles.com"),
    BOMBTRACK("Bombtrack", "https://bombtrack.com"),
    BPM_IMPORTS("BPM Imports", "https://bpmimports.com"),
    BREEZER("Breezer", "https://www.breezerbikes.com"), // mostly road bike
    BRODIE("Brodie", "https://www.brodiebikes.com"),
    BROMPTON("Brompton", "https://www.brompton.com"),
    B_TWIN("B'Twin", "https://www.decathlon.com/collections/btwin"),
    BULLS("Bulls", "https://www.bullsbikesusa.com"),
    BUNCH_BIKES("Bunch Bikes", "https://www.bunchbike.com"),
    BUZZ("Buzz", "https://www.buzzbicycles.com"),
    BYOCYCLES("Byocycles", "https://www.byocycles.com"),
    // Removed C3STROM - e-bike specialist
    CAIRN("Cairn", "https://www.cairncycles.com"),
    CALIBRE("Calibre", "https://www.gooutdoors.co.uk/brands/calibre"),
    CALIFORNIA_BICYCLE_FACTORY("California Bicycle Factory", "https://californiabicyclefactory.com"),
    CANFIELD("Canfield", "https://canfieldbikes.com"),
    CANNONDALE("Cannondale", "https://www.cannondale.com"),
    CANYON("Canyon", "https://www.canyon.com"),
    CARQON("Carqon", "https://www.carqon.com"),
    CARVER("Carver", "https://carverbikes.com"),
    CASATI("Casati", "https://www.casati-bikes.com"),
    CERO("Cero", "https://www.cero.bike"),
    CERVELO("Cervelo", "https://www.cervelo.com"), // mostly road bike
    CHROMAG("Chromag", "https://www.chromagbikes.com"),
    CINELLI("Cinelli", "https://www.cinelli.it"),
    CIPOLLINI("Cipollini", "https://www.cipollini.com"),
    // Removed CIVI_BIKES - e-bike focused
    CLAUD_BUTLER("Claud Butler", "https://www.claudbutler.co.uk"),
    CLEARY("Cleary", "https://www.clearybikes.com"),
    COLNAGO("Colnago", "https://www.colnago.com"),
    COMMENCAL("Commencal", "https://www.commencal-store.com"),
    CONDOR("Condor", "https://www.condorcycles.com"),
    CORIMA("Corima", "https://www.corima.com"),
    CORRATEC("Corratec", "https://www.corratec.com"),
    CORTINA("Cortina", "https://www.cortinacycles.com"),
    CO_OP_CYCLES("Co-op Cycles", "https://www.rei.com/b/co-op-cycles"),
    // Removed COWBOY - e-bike only
    CRUSSIS("Crussis", "https://www.crussis.com"),
    CUBE("Cube", "https://www.cube.eu"),
    CUDA("Cuda", "https://www.cudabikes.co.uk"),
    CURVE("Curve", "https://www.curvecycling.com.au"),
    CYCLE_OF_GOOD("Cycle of Good", "https://www.cycleofgood.com"),
    DALLINGRIDGE("Dallingridge", "https://www.dallingridge.com"),
    DARTMOOR("Dartmoor", "https://dartmoor-bikes.com"),
    DASSI("Dassi", "https://www.dassi.com"),
    DAWES("Dawes", "https://dawescycles.com"),
    DEL_SOL("Del Sol", "https://www.delsolbikes.com"),
    DENVER("Denver", "https://www.denver-bikes.com"),
    DEVIATE("Deviate", "https://www.deviatecycles.com"),
    DEVINCI("Devinci", "https://www.devinci.com"),
    DIAMONDBACK("Diamondback", "https://www.diamondback.com"),
    DINO_BIKES("Dino Bikes", "https://www.dinobikes.com"),
    DMR("DMR", "https://www.dmrbikes.com"),
    DOLAN("Dolan", "https://www.dolan-bikes.com"),
    // Removed DOST - e-bike specialist
    // Removed EAHORA - e-bike specialist
    EARLY_RIDER("Early Rider", "https://www.earlyrider.com"),
    EARLY_RIDER_LIMITED("Early Rider Limited", "https://www.earlyrider.com"),
    EDDY_MERCKX("Eddy Merckx", "https://www.eddymerckx.com"),
    EG("EG", "https://www.egbicycles.com"),
    // Removed E_JOE - e-bike specialist
    ELECTRA("Electra", "https://www.electrabike.com"),
    // Removed ELECTRIC_BIKE_COMPANY - e-bike focused
    // Removed ELECTRIC_BIKE_TECHNOLOGIES - e-bike focused
    ELLSWORTH("Ellsworth", "https://www.ellsworthbikes.com"),
    ELOPS("Elops", "https://www.decathlon.com/collections/elops"),
    E_LUX("E-Lux", "https://www.eluxbikes.com"), // mostly ebike (not removed as not exclusively ebike)
    EMINENT("Eminent", "https://www.eminentcycles.com"),
    // Removed EMOJO - e-bike specialist
    // Removed EMU_BIKES - e-bike focused
    ENVE("Enve", "https://www.enve.com"),
    // Removed ENZO_EBIKES - e-bike only
    ESKER("Esker", "https://eskercycles.com"),
    // Removed ESPIN - e-bike specialist
    // Removed EUNORAU - e-bike specialist
    // Removed EVELO - e-bike specialist
    EVIL("Evil", "https://www.evil-bikes.com"),
    FACTOR("Factor", "https://factorbikes.com"),
    FAIRDALE("Fairdale", "https://fairdalebikes.com"),
    FALCON("Falcon", "https://www.falconcycles.com"),
    FANTIC("Fantic", "https://www.fanticbicycles.com"),
    FARA("Fara", "https://faracycles.com"),
    FARADAY("Faraday", "https://www.faradaybikes.com"),
    FELT("Felt", "https://feltbicycles.com"), // mostly road bike
    // Removed FLYER - ebike only
    FLX("FLX", "https://flx.bike"),
    FOCUS("Focus", "https://www.focus-bikes.com"),
    FOES("Foes", "https://www.foesbikes.com"),
    FONDRIEST("Fondriest", "https://www.fondriest.com"),
    FORBIDDEN("Forbidden", "https://www.forbiddenbike.com"),
    FORESTAL("Forestal", "https://forestalbikes.com"),
    FORME("Forme", "https://formebikes.co.uk"),
    FRAMED("Framed", "https://www.framedbikes.com"),
    FREESPIRIT("Freespirit", "https://www.freespiritbikes.com"),
    FROG("Frog", "https://www.frogbikes.com"),
    FTH_POWER("FTH Power", "https://www.fthpower.com"),
    FUJI("Fuji", "https://www.fujibikes.com"),
    FURO_SYSTEMS("Furo Systems", "https://www.furosystems.com"),
    GARY_FISHER("Gary Fisher", "https://www.trekbikes.com/gary-fisher-collection"),
    GASGAS("GasGas", "https://www.gasgas.com"),
    GAZELLE("Gazelle", "https://www.gazellebikes.com"),
    GEOMETRON("Geometron", "https://www.geometronbikes.co.uk"),
    GEPIDA("Gepida", "https://www.gepida.com"),
    GHOST("Ghost", "https://www.ghost-bikes.com"),
    GIANT("Giant", "https://www.giant-bicycles.com"),
    GLOBBER("Globber", "https://www.globber.com"),
    GOCYCLE("GoCycle", "https://gocycle.com"),
    GO_POWER("Go Power", "https://gopowerbike.com"),
    GROWLER_BIKES("Growler Bikes", "https://www.growlerbikes.com"),
    GT("GT", "https://www.gtbicycles.com"),
    GUERCIOTTI("Guerciotti", "https://www.guerciotti.it"), // mostly road bike
    GUERRILLA_GRAVITY("Guerrilla Gravity", "https://ridegg.com"),
    GURU("Guru", "https://www.gurucycles.com"),
    HAIBIKE("Haibike", "https://www.haibike.com"),
    HARO("Haro", "https://harobikes.com"),
    HEAD("Head", "https://www.head-bike.com"),
    HILAND("Hiland", "https://www.hilandbike.com"),
    // Removed HIMIWAY - ebike only
    HOLDSWORTH("Holdsworth", "https://www.holdsworth-bikes.co.uk"),
    HOPE_TECHNOLOGY("Hope Technology", "https://www.hopetech.com"),
    HUFFY("Huffy", "https://www.huffy.com"),
    HUSQVARNA("Husqvarna", "https://www.husqvarna-bicycles.com"),
    IBIS("Ibis", "https://www.ibiscycles.com"),
    INTENSE("Intense", "https://intensecycles.com"),
    IZIP("iZip", "https://www.izipelectric.com"),
    JAMIS("Jamis", "https://www.jamisbikes.com"),
    JETSON("Jetson", "https://www.ridejetson.com"),
    // Removed JUICED_BIKES - e-bike focused
    JULIANA("Juliana", "https://www.julianabicycles.com"),
    JUPITERBIKE("JupiterBike", "https://www.jupiterbike.com"),
    K2("K2", "https://www.k2bikes.com"),
    KALKHOFF("Kalkhoff", "https://www.kalkhoff-bikes.com"),
    KAVENZ("Kavenz", "https://www.kavenz.com"),
    KELLYS("Kellys", "https://www.kellysbike.com"),
    KESTREL("Kestrel", "https://www.kestrelbicycles.com"), // road only
    KETTLER("Kettler", "https://www.kettler.co.uk"),
    KHS("KHS", "https://khsbicycles.com"),
    KINESIS("Kinesis", "https://kinesisbikes.co.uk"),
    KONA("Kona", "https://www.konaworld.com"),
    KROSS("Kross", "https://kross-europe.eu"),
    KTM("KTM", "https://www.ktm-bikes.at"),
    KUOTA("Kuota", "https://www.kuotacycle.it"),
    LAPIERRE("LAPIERRE", "https://www.lapierrebikes.com"),
    LAST("Last", "https://www.last-bikes.com"),
    LAUF("Lauf", "https://www.laufcycling.com"),
    // Removed LECTRIC - e-bike specialist
    // Removed LECTRIC_EBIKES - e-bike specialist
    LEKKER("Lekker", "https://www.lekkerbikes.com"),
    LIBERTY_TRIKE("Liberty Trike", "https://libertytrike.com"),
    LIGHTWEIGHT("Lightweight", "https://lightweight.info"),
    LITESPEED("Litespeed", "https://litespeed.com"),
    LITEVILLE("Liteville", "https://www.liteville.com"),
    LIV("Liv", "https://www.liv-cycling.com"),
    LOMBARDO("Lombardo", "https://www.lombardobikes.com"),
    LYNSKEY("Lynskey", "https://lynskeyperformance.com"),
    M2S("M2S", "https://shop.m2sbikes.com"),
    // Removed MAGNUM - e-bike specialist
    MARIN("Marin", "https://www.marinbikes.com"),
    MASI("Masi", "https://masibikes.com"),
    MASON("Mason", "https://masoncycles.cc"),
    MAXFOOT("Maxfoot", "https://www.maxfoot.com"),
    MDE("MDE", "https://www.mdebikes.com"),
    MEC("MEC", "https://www.mec.ca"),
    MEEKBOYZ("Meekboyz", "https://www.meekboyz.com"),
    MERIDA("Merida", "https://www.merida-bikes.com/en"),
    // Removed MOD_BIKES - e-bike focused
    MOMENTUM("Momentum", "https://www.momentum-biking.com"),
    MONDRAKER("Mondraker", "https://www.mondraker.com"),
    MONGOOSE("Mongoose", "https://www.mongoose.com"),
    MONTAGUE("Montague", "https://www.montaguebikes.com"),
    MOOTS("Moots", "https://moots.com"),
    MOTIV("Motiv", "https://www.motivelectricbikes.com"),
    MOTOBECANE("Motobecane", "https://www.motobecane.com"),
    MOUSTACHE("Moustache", "https://moustachebikes.com"),
    // Removed NAKTO - e-bike specialist
    NCM("NCM", "https://www.ncmbikes.com"),
    NICOLAI("Nicolai", "https://nicolai-bicycles.com"),
    NINER("Niner", "https://www.ninerbikes.com"),
    // Removed NIREEKA - e-bike specialist
    NORCO("Norco", "https://www.norco.com"),
    NORDEST("Nordest", "https://nordestcycles.com"),
    NS("NS", "https://www.ns-bikes.com"),
    NUKEPROOF("Nukeproof", "https://nukeproof.com"),
    OBED("Obed", "https://obedbikes.com"),
    OCOEE("Ocoee", "https://www.ocoeebikes.com"),
    OGGI("OGGI", "https://oggibikes.com.br"),
    OHM("Ohm", "https://www.ohmcycles.com"),
    ON_ONE("On-One", "https://planetx.co.uk/collections/on-one-bikes"),
    OPEN("Open", "https://www.opencycle.com"),
    ORANGE("Orange", "https://www.orangebikes.com"),
    ORBEA("Orbea", "https://www.orbea.com"),
    ORRO("Orro", "https://www.orrobikes.com"),
    OTSO("Otso", "https://otsocycles.com"),
    OXYLANE("Oxylane", "https://www.oxylane.com"),
    PACE("Pace", "https://pacecycles.com"),
    PARLEE("Parlee", "https://parleecycles.com"),
    PASHLEY("Pashley", "https://www.pashley.co.uk"),
    PATROL("Patrol", "https://patrol-bike.com"),
    // Removed PEDEGO - e-bike specialist
    PENDLETON("Pendleton", "https://www.pendleton-bikes.co.uk"),
    PINARELLO("Pinarello", "https://pinarello.com"),
    PINNACLE("Pinnacle", "https://www.evanscycles.com/brands/pinnacle"),
    PIVOT("Pivot", "https://www.pivotcycles.com/en"),
    POLE("Pole", "https://polebicycles.com"),
    POLYGON("Polygon", "https://www.polygonbikes.com"),
    POSEIDON("Poseidon", "https://www.poseidonbike.com"),
    PREMIUM("Premium", "https://www.premiumbmx.com"),
    PREVELO("Prevelo", "https://www.prevelobikes.com"),
    PRIORITY("Priority", "https://www.prioritybicycles.com"),
    PRIVATEER("Privateer", "https://www.privateerbikes.com"),
    PRODUCTION_PRIVEE("Production Privee", "https://production-privee.com"),
    PROPAIN("Propain", "https://www.propain-bikes.com"),
    // Removed PROPELLA - e-bike specialist
    PUKY("Puky", "https://www.puky.net"),
    PURE("Pure", "https://www.purecycles.com"),
    PYGA("Pyga", "https://www.pygaindustries.com"),
    QUALISPORTS("Qualisports", "https://www.qualisports.us"),
    QUINTANA_ROO("Quintana Roo", "https://quintanarootri.com"),
    RAAW("RAAW", "https://raawmtb.com"),
    RADIO("Radio", "https://www.radiobikes.com"),
    RAGLEY("Ragley", "https://ragleybikes.com"),
    RALEIGH("Raleigh", "https://www.raleigh.co.uk/gb/en"),
    RAMBO_BIKES("Rambo Bikes", "https://www.rambobikes.com"),
    // Removed RATTAN - e-bike specialist
    REDLINE("Redline", "https://redlinebicycles.com"),
    REEB("REEB", "https://reebcycles.com"),
    REID("Reid", "https://www.reidbikes.com"),
    REVEL("Revel", "https://revelbikes.com"),
    REVOLVE("Revolve", "https://www.revolvebike.com"),
    RIBBLE("Ribble", "https://www.ribblecycles.co.uk"),
    RIDGEBACK("Ridgeback", "https://www.ridgeback.co.uk"),
    RIDLEY("Ridley", "https://www.ridley-bikes.com"),
    RIESE_MULLER("Riese & Müller", "https://www.r-m.de"),
    RITCHEY("Ritchey", "https://us.ritcheylogic.com"),
    RIVA("Riva", "https://rivabike.com"),
    RIVERSIDE("Riverside", "https://www.decathlon.com/collections/riverside"),
    // Removed RIZE_BIKES - e-bike specialist
    ROCKRIDER("Rockrider", "https://www.decathlon.com/collections/rockrider"),
    ROCKY_MOUNTAIN("Rocky Mountain", "https://bikes.com"),
    RONDO("Rondo", "https://rondo.cc"),
    ROODOG("Roodog", "https://www.roodogbikes.com"),
    ROSE("Rose", "https://www.rosebikes.com"),
    ROSSIGNOL("Rossignol", "https://www.rossignol.com/bikes"),
    SAGE("Sage", "https://www.sagetitanium.com"),
    SALSA("Salsa", "https://www.salsacycles.com"),
    SANTA_CRUZ("Santa Cruz", "https://www.santacruzbicycles.com"),
    SAVA("Sava", "https://www.savadeck-bike.com"),
    SCAMP("Scamp", "https://www.scampbikes.com"),
    SCOR("SCOR", "https://www.scor-mtb.com"),
    SCOTT("SCOTT", "https://www.scott-sports.com"),
    SENSA("Sensa", "https://www.sensabikes.com"),
    SHERPA("Sherpa", "https://sherpabikes.com"),
    SILVERBACK("Silverback", "https://silverbacklab.com"),
    SKORPION("Skorpion", "https://skorpionbikes.com"),
    SOMA("Soma", "https://www.somafab.com"),
    SONDER("Sonder", "https://alpkit.com/collections/sonder"),
    // Removed SONDORS - primarily e-bikes
    SOUL_FAST_E_BIKES("Soul Fast E-Bikes", "https://www.soulfastebikes.com"),
    SPARK_BIKES("Spark Bikes", "https://sparkbikes.com"),
    SPARK_CYCLEWORKS("Spark Cycleworks", "https://www.sparkcycleworks.com"),
    SPAWN("Spawn", "https://spawncycles.com"),
    SPECIALIZED("Specialized", "https://www.specialized.com"),
    SPOT("Spot", "https://spotbikes.com"),
    STANTON("Stanton", "https://www.stantonbikes.com"),
    STATE_BICYCLE_CO("State Bicycle Co", "https://www.statebicycle.com"),
    STILUS("Stilus", "https://www.stilusbikes.com"),
    STRIDER("Strider", "https://www.striderbikes.com"),
    // Removed SUPER73 - e-bike specialist
    SUPERIOR("Superior", "https://superiorbikes.eu"),
    // Removed SURFACE_604 - ebike only
    // Removed SURFACES604 - duplicate of SURFACE_604 (ebike only)
    SURLY("Surly", "https://surlybikes.com"),
    SYNERGY("Synergy", "https://www.synergybikes.com"),
    TERN("Tern", "https://www.ternbicycles.com"),
    THESIS("Thesis", "https://thesis.bike"),
    THOK("Thok", "https://thokbikes.com"),
    TIME("Time", "https://www.timesport.com"),
    TITUS("Titus", "https://planetx.co.uk/collections/titus-bikes"),
    TOUT_TERRAIN("Tout Terrain", "https://tout-terrain.de"),
    TOWER("Tower", "https://www.towerbicycles.com"),
    TRANSITION("Transition", "https://www.transitionbikes.com"),
    TREK("Trek", "https://www.trekbikes.com/us/en_US"),
    TRIBAN("Triban", "https://www.decathlon.com/collections/triban"),
    TRIFOX("Trifox", "https://www.trifoxbike.com"),
    TUMBLEWEED("Tumbleweed", "https://tumbleweed.cc"),
    TUNTURI("Tunturi", "https://www.tunturi.com"),
    // Removed TURBOANT - e-bike specialist
    TURNER("Turner", "https://turnerbikes.com"),
    UNIVEGA("Univega", "https://www.univega-usa.com"),
    URBAN_DRIVESTYLE("Urban Drivestyle", "https://urbandrivestyle.com"),
    // Removed URTOPIA - e-bike specialist
    VAAST("Vaast", "https://vaastbikes.com"),
    // Removed VANMOOF - e-bike specialist
    VAN_RYSEL("Van Rysel", "https://www.decathlon.com/collections/van-rysel"),
    // Removed VBIKE - e-bike specialist
    // Removed VELEC - e-bike specialist
    VENTUM("Ventum", "https://ventumracing.com"),
    VERDE("Verde", "https://verdebmx.com"),
    VIATHON("Viathon", "https://viathonbicycles.com"),
    VIELO("Vielo", "https://vielo.cc"),
    VIKING("Viking", "https://viking-bikes.com"),
    // Removed VINTAGE_ELECTRIC - e-bike focused
    VITUS("Vitus", "https://vitusbikes.com"),
    // Removed VOLTBIKE - e-bike specialist
    VOODOO("Voodoo", "https://www.voodoocycles.com"),
    VOTEC("Votec", "https://www.votec.com"),
    VVOLT("VVOLT", "https://vvolt.com"),
    WE_ARE_ONE("We Are One", "https://www.weareonecomposites.com"),
    WHYTE("Whyte", "https://whytebikes.com"),
    WIGGINS("Wiggins", "https://www.wigginsbikes.com"),
    WILDSYDE("Wildsyde", "https://wildsyde.com"),
    WILIER("Wilier", "https://www.wilier.com"),
    WISPER("Wisper", "https://wisperbikes.com"),
    XN("XN", "https://xnbikes.com"),
    XTRACYCLE("Xtracycle", "https://www.xtracycle.com"),
    YETI("Yeti", "https://yeticycles.com"),
    YT_INDUSTRIES("YT", "https://www.yt-industries.com"),
    YUBA("Yuba", "https://yubabikes.com"),
    ZEN("Zen", "https://www.zenbikes.com"),
    ZERODE("Zerode", "https://www.zerodebikes.com");

    private final String text;
    private final String url;

    BikeBrand(String text) {
        this.text = text;
        this.url = "";
    }

    BikeBrand(String text, String official_url) {
        this.text = text;
        this.url = official_url;
    }


    /**
     * Brands common name used by major retailers/dealers
     *
     * @return common name
     */
    public String getText() {
        return text;
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
        return Arrays.stream(values()).filter(b -> b.text.equalsIgnoreCase(name.trim())).findFirst();
    }
}
