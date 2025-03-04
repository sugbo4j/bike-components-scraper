package nz.co.sugbo4j.bike_components_scraper.model;

import java.util.Arrays;
import java.util.Optional;

public enum WheelSize {
    // Road and Hybrid Bikes
    ROAD_700C(700, 622, "700c"),
    ROAD_650C(650, 571, "650c"),
    ROAD_650B(650, 584, "650b"),
    ROAD_26(26, 559, "26\""),
    ROAD_27(27, 630, "27\""),

    // Mountain Bikes
    MTB_29(29, 622, "29\""),
    MTB_27_5(27.5, 584, "27.5\""),
    MTB_26(26, 559, "26\""),
    MTB_24(24, 507, "24\""),

    // BMX and Kids' Bikes
    BMX_20(20, 406, "20\""),
    KIDS_18(18, 355, "18\""),
    KIDS_16(16, 305, "16\""),
    KIDS_14(14, 254, "14\""),
    KIDS_12(12, 203, "12\"");

    private final double sizeInches;
    private final int isoSizeMm;
    private final String commonName;


    WheelSize(double sizeInches, int isoSizeMm, String commonName) {
        this.sizeInches = sizeInches;
        this.isoSizeMm = isoSizeMm;
        this.commonName = commonName;

    }

    public double getSizeInches() {
        return sizeInches;
    }

    public int getIsoSizeMm() {
        return isoSizeMm;
    }

    public String getCommonName() {
        return commonName;
    }

    @Override
    public String toString() {
        return commonName + " (ISO " + isoSizeMm + "mm)";
    }

    /**
     * Find a wheel size by its ISO diameter in millimeters
     */
    public static Optional<WheelSize> findByIsoSize(int isoSizeMm) {
        return Arrays.stream(values()).filter(s -> s.getIsoSizeMm() == isoSizeMm).findFirst();
    }

    /**
     * Find a wheel size by its approximate inch measurement
     */
    public static Optional<WheelSize> findByInches(double inches) {
        return Arrays.stream(values()).filter(s -> Math.abs(s.getSizeInches() - inches) < 0.1).findFirst();
    }
}
