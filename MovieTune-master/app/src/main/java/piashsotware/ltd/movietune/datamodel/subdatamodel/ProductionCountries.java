package piashsotware.ltd.movietune.datamodel.subdatamodel;

/**
 * Created by piash on 11/25/16.
 */

public class ProductionCountries {
    private String iso_3166_1;
    private String name;

    public ProductionCountries(String iso_3166_1, String name) {
        this.iso_3166_1 = iso_3166_1;
        this.name = name;
    }

    public String getIso_3166_1() {
        return iso_3166_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ProductionCountries{" +
                "iso_3166_1='" + iso_3166_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
