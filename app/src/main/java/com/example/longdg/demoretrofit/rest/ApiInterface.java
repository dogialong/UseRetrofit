package com.example.longdg.demoretrofit.rest;

import com.example.longdg.demoretrofit.model.PhimResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Longdg on 26/05/2016.
 */
public interface ApiInterface {
    @GET("movie/top_rated")
    Call<PhimResponse> getTopRatedMovies(@Query("api_key") String apiKey);
    @GET("movie/{id}")
    Call<PhimResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
