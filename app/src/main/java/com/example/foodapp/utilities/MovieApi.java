package com.example.foodapp.utilities;

import com.example.foodapp.models.MovieModel;
import com.example.foodapp.response.MovieResponse;
import com.example.foodapp.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //https://api.themoviedb.org/3/movie/popular?api_key=e1ae0d86192673ab8739d4753f97b0ac&page=1
    // search for movies
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String api_key,
            @Query("query") String query
    );
    // get the popular movies
    @GET("/3/movie/popular")
    Call<MovieSearchResponse> getMovies(
            @Query("api_key") String api_key,
            @Query("page") int page
    );
    //https://api.themoviedb.org/3/movie/550?api_key=e1ae0d86192673ab8739d4753f97b0ac
    // Search with the ID
    @GET("/3/movie/{movie_id}")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key );

}
