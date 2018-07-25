package piashsotware.ltd.movietune.api;


import java.util.List;

import piashsotware.ltd.movietune.datamodel.MovieDetailPayloadModel;
import piashsotware.ltd.movietune.datamodel.NewReliesePayloadModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by piash on 11/24/16.
 */

public interface ApiMovieInterface {

    @GET("now_playing?api_key=c37d3b40004717511adb2c1fbb15eda4& page=1")
    Call<NewReliesePayloadModel> newRelieseMovieNetworkCall();

    @GET("top_rated?api_key=c37d3b40004717511adb2c1fbb15eda4&page=1")
    Call<NewReliesePayloadModel> topRatedMovieNetworkCall();

    @GET("upcoming?api_key=c37d3b40004717511adb2c1fbb15eda4&page=1")
    Call<NewReliesePayloadModel> upCommingMovieNetworkCall();

    @GET("{movie_id}?api_key=c37d3b40004717511adb2c1fbb15eda4")
    Call<MovieDetailPayloadModel> movieDetailNetworkCall(@Path("movie_id") int movieId);

    @GET("{movie_id}/similar?api_key=c37d3b40004717511adb2c1fbb15eda4&page= 1")
    Call<NewReliesePayloadModel> similarMovieNetworkCall(@Path("movie_id") int movieId);
}
