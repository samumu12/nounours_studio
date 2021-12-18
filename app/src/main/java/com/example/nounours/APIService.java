package com.example.nounours;

import com.example.nounours.Data.DataDiscover;
import com.example.nounours.Data.DataToken;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIService {
    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/discover/movie")
    Call<DataDiscover> getDiscover(@Query("api_key") String Auth);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/authentication/token/new")
    Call<DataToken> getToken(@Query("api_key") String Auth);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("/3/authentication/token/validate_with_login")
    Call<DataToken> postLogin(@Query("api_key") String Auth, @Body String user);
}
