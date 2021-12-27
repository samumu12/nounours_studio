package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public class DataSearch {

    @SerializedName("page")
    int page;

    @SerializedName("results")
    public DataSearchList[] res;

    @SerializedName("total_results")
    int total_results;

    @SerializedName("total_pages")
    int total_pages;
}
