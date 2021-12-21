package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public class DataAccount {

    @SerializedName("id")
    public int id;

    @SerializedName("avatar")
    public DataAvatar avatar;

    @SerializedName("iso_639_1")
    public String iso_639_1;

    @SerializedName("iso_3166_1")
    public String iso_3166_1;

    @SerializedName("name")
    public String name;

    @SerializedName("include_adult")
    public boolean include_adult;

    @SerializedName("username")
    public String username;

}
