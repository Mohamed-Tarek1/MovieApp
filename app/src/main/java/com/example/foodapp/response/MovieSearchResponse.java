package com.example.foodapp.response;

import com.example.foodapp.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

// this class is for getting multiple movies (Movie List) - popular movies
public class MovieSearchResponse {
    

    @SerializedName("results")
    @Expose()
    private List<MovieModel> movies;

    @SerializedName("total_results  ")
    @Expose()
    private int total_count;

    public int getTotal_count(){

        return total_count;
    }

    public List<MovieModel> getMovies(){

        return movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
