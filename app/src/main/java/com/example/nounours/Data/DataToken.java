package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public final class DataToken {

    @SerializedName("success")
    public boolean success;

    @SerializedName("expires_at")
    public String expiration;

    @SerializedName("request_token")
    public String token;
}
