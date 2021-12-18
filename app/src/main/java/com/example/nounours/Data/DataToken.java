package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public final class DataToken {

    @SerializedName("success")
    boolean success;

    @SerializedName("expires_at")
    String expiration;

    @SerializedName("request_token")
    String token;
}
