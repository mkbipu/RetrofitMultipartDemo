package com.example.user.movietune.api;

import com.example.user.movietune.model.MovieDetailData;
import com.example.user.movietune.model.NewReleaseData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by User on 4/11/2018.
 */

public interface MovieInterface {
    @GET("now_playing?api_key=c37d3b40004717511adb2c1fbb15eda4& page=5")
    Call<NewReleaseData> newRelieseMovieNetworkCall();

    @GET("top_rated?api_key=c37d3b40004717511adb2c1fbb15eda4&page=5")
    Call<NewReleaseData> topRatedMovieNetworkCall();

    @GET("upcoming?api_key=c37d3b40004717511adb2c1fbb15eda4&page=5")
    Call<NewReleaseData> upCommingMovieNetworkCall();

    @GET("{movie_id}?api_key=c37d3b40004717511adb2c1fbb15eda4")
    Call<MovieDetailData> movieDetailNetworkCall(@Path("movie_id") int movieId);

    @GET("{movie_id}/similar?api_key=c37d3b40004717511adb2c1fbb15eda4&page= 5")
    Call<NewReleaseData> similarMovieNetworkCall(@Path("movie_id") int movieId);
}
