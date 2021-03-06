package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public final class DataDiscover {

    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public DataDiscoverList res [];

    @SerializedName("total_pages")
    public int page_nb;

    @SerializedName("total_results")
    public int res_nb;
}