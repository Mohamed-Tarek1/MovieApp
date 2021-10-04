package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.foodapp.models.MovieModel;
import com.example.foodapp.request.Servicey;
import com.example.foodapp.response.MovieSearchResponse;
import com.example.foodapp.utilities.Credentials;
import com.example.foodapp.utilities.MovieApi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           GetRetrofitResponseAccodingToID();
            }
        });

    }
    // search for multiple movies with a query
    private void GetRetrofitResponse() {
        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Action");

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
                if(response.code() == 200){
                    Log.v("Tag","the response"+response.body().toString());
                    List<MovieModel> movieList = new ArrayList<>(response.body().getMovies());

                    for (MovieModel movie: movieList){
                        Log.v("Tag","the Title :- "+movie.getTitle());
                    }
                }
                else
                    {
                    try{
                        Log.v("Tag","error"+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
            }
        });

    }

    // search for movies with the id
    private void GetRetrofitResponseAccodingToID(){
        MovieApi movieApi = Servicey.getMovieApi();
        Call<MovieModel> responseCall =movieApi.getMovie(550,Credentials.API_KEY);
        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.code() == 200) {
                    MovieModel movie = response.body();
                    Log.v("Tag", "the response " + movie.getTitle());
                }
                else{
                    try{
                        Log.v("Tag","error"+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }

}