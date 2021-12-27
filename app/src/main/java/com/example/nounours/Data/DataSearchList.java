package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public final class DataSearchList {

    @SerializedName("adult")
    public boolean adult;

    @SerializedName("backdrop_path")
    public String backdrop_path;

    @SerializedName("genre_ids")
    public int genre_ids [];

    @SerializedName("id")
    public int id;

    @SerializedName("original_language")
    public String language;

    @SerializedName("original_title")
    public String original_title;

    @SerializedName("overview")
    public String overview;

    @SerializedName("popularity")
    public float popularity;

    @SerializedName("poster_path")
    public String poster_path;

    @SerializedName("release_date")
    public String release_date;

    @SerializedName("title")
    public String title;

    @SerializedName("video")
    public boolean video;

    @SerializedName("vote_average")
    public float vote_average;

    @SerializedName("vote_count")
    public float vote_count;
}