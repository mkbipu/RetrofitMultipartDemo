package piashsotware.ltd.movietune.datamodel;

import java.util.List;

import piashsotware.ltd.movietune.datamodel.subdatamodel.Dates;
import piashsotware.ltd.movietune.datamodel.subdatamodel.InformationModel;

/**
 * Created by piash on 11/24/16.
 */

public class NewReliesePayloadModel {

    private int page;
    private List<InformationModel> results;
    private Dates dates;
    private int total_pages;
    private int total_results;

    public NewReliesePayloadModel(int page, List<InformationModel> results, Dates dates, int total_pages, int total_results) {
        this.page = page;
        this.results = results;
        this.dates = dates;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public List<InformationModel> getResults() {
        return results;
    }

    public Dates getDates() {
        return dates;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    @Override
    public String toString() {
        return "NewReliesePayloadModel{" +
                "page=" + page +
                ", results=" + results +
                ", dates=" + dates +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}
