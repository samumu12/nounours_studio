package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public final class DataFavorites {

    @SerializedName("page")
    public int page;

    @SerializedName("results")
    public DataFavoritesList res [];

    @SerializedName("total_pages")
    public int page_nb;

    @SerializedName("total_results")
    public int res_nb;
}