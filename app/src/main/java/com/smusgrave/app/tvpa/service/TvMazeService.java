package com.smusgrave.app.tvpa.service;

import com.smusgrave.app.tvpa.model.Show;
import com.smusgrave.app.tvpa.model.ShowQuery;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface TvMazeService {

    String BASE_URL = "http://api.tvmaze.com/";

    @GET("search/shows")
    Observable<List<ShowQuery>> getShows(@Query("q") String query);

    @GET("/shows/{id}")
    Observable<Show> getShow(@Path("id") int id);

}
