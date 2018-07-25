package piashsotware.ltd.movietune.datamodel.subdatamodel;

/**
 * Created by piash on 11/25/16.
 */

public class SpokenLanguage {

    private String iso_639_1;
    private String name;

    public SpokenLanguage(String iso_639_1, String name) {
        this.iso_639_1 = iso_639_1;
        this.name = name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SpokenLanguage{" +
                "iso_639_1='" + iso_639_1 + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
