package com.example.foodapp.models;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {

    // Model class for movies
    private  String title;
    private  String poster_path;
    private  String release_date;
    private  String overview;
    private  int id;
    private  float vote_average;

    // Constructor

    public MovieModel(String title, String poster_path, String release_date, String overview, int id, float vote_average) {

    }

    //getters

    protected MovieModel(Parcel in) {
        title = in.readString();
        poster_path = in.readString();
        release_date = in.readString();
        overview = in.readString();
        id = in.readInt();
        vote_average = in.readFloat();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getMovie_overview() {
        return overview;
    }

    public int getMovie_id() {
        return id;
    }

    public float getVote_average() {
        return vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(release_date);
        dest.writeString(overview);
        dest.writeInt(id);
        dest.writeFloat(vote_average);
    }
}
