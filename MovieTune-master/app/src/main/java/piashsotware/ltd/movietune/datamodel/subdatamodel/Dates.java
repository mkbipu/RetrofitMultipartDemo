package piashsotware.ltd.movietune.datamodel.subdatamodel;

/**
 * Created by piash on 11/24/16.
 */

public class Dates {
    private String maximum;
    private String minimum;

    public Dates(String maximum, String minimum) {
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public String getMinimum() {
        return minimum;
    }

    @Override
    public String toString() {
        return "Dates{" +
                "maximum='" + maximum + '\'' +
                ", minimum='" + minimum + '\'' +
                '}';
    }
}
