package com.example.nounours.Controllers;

import android.util.Log;

import com.example.nounours.Data.DataToken;
import com.example.nounours.Data.User;
import com.example.nounours.LoginActivity;
import com.example.nounours.RetrofitAPI;
import com.example.nounours.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController {
    APIService service = RetrofitAPI.getRetrofit();
    String _token;

    public String getToken() {
        Call<DataToken> call = service.getToken("d3a6973dd4a2b15cbcda2963be1fd795");

        call.enqueue(new Callback<DataToken>() {
            @Override
            public void onResponse(Call<DataToken> call, Response<DataToken> response) {
                if (response.body().success) {
                    Log.d("4", response.toString());
                    _token = response.body().token;
                }
            }

            @Override
            public void onFailure(Call<DataToken> call, Throwable t) {
                    _token = null;
            }
        });

        return (_token);
    }

    public void getLogin(String username, String password, String token) {
        User user = new User(username, password, token);
        Response<DataToken> response;

        Call<DataToken> call = service.postLogin("d3a6973dd4a2b15cbcda2963be1fd795", user);

        call.enqueue(new Callback<DataToken>() {
            @Override
            public void onResponse(Call<DataToken> call, Response<DataToken> response) {
                if (response.body().success) {LoginActivity.fa.finish();}
            }

            @Override
            public void onFailure(Call<DataToken> call, Throwable t) {

            }
        });
    }
}