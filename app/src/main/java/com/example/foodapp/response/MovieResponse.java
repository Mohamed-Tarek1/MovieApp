package com.example.foodapp.response;

import com.example.foodapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// the class is for one movie request

public class MovieResponse {

    // 1- finding the movie object
    @SerializedName("results")
    @Expose
    private MovieModel movie ;

    public MovieModel getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
