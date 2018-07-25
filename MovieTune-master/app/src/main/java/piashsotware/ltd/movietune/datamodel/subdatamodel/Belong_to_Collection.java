package piashsotware.ltd.movietune.datamodel.subdatamodel;

/**
 * Created by piash on 11/27/16.
 */

public class Belong_to_Collection {

            private int id;
            private String name;
            private String poster_path;
            private String backdrop_path;

    public Belong_to_Collection(int id, String name, String poster_path, String backdrop_path) {
        this.id = id;
        this.name = name;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    @Override
    public String toString() {
        return "Belong_to_Collection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", backdrop_path='" + backdrop_path + '\'' +
                '}';
    }
}
