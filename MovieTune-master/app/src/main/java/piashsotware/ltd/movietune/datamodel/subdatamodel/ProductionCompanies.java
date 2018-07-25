package piashsotware.ltd.movietune.datamodel.subdatamodel;

/**
 * Created by piash on 11/25/16.
 */

public class ProductionCompanies {
    private String name;
    private int id;

    public ProductionCompanies(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ProductionCompanies{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
