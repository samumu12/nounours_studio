package com.example.nounours.Interfaces;

import com.example.nounours.Data.DataAccount;
import com.example.nounours.Data.DataDiscover;
import com.example.nounours.Data.DataFavorites;
import com.example.nounours.Data.DataSessionId;
import com.example.nounours.Data.DataToken;
import com.example.nounours.Data.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/discover/movie")
    Call<DataDiscover> getDiscover(@Query("api_key") String Auth, @Query("page") Integer page);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/account/{account_id}/favorite/movies")
    Call<DataFavorites> getFavorites(@Path("account_id") int id, @Query("api_key") String Auth, @Query("session_id") String sessionId, @Query("page") Integer page);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("/3/authentication/session/new")
    Call<DataSessionId> getSessionId(@Query("api_key") String Auth, @Body String request_token);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/account")
    Call<DataAccount> getAccount(@Query("api_key") String Auth, @Query("session_id") String session);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @GET("/3/authentication/token/new")
    Call<DataToken> getToken(@Query("api_key") String Auth);

    @Headers({ "Content-Type: application/json;charset=UTF-8" })
    @POST("/3/authentication/token/validate_with_login")
    Call<DataToken> postLogin(@Query("api_key") String Auth, @Body User user);
}
