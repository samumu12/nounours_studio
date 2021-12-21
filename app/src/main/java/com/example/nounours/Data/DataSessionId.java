package com.example.nounours.Data;

import com.google.gson.annotations.SerializedName;

public class DataSessionId {

    @SerializedName("success")
    public boolean success;

    @SerializedName("guest_session_id")
    public String sessionId;
}
