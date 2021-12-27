package com.example.nounours.Controllers;

import android.util.Log;

import com.example.nounours.Data.DataAccount;
import com.example.nounours.Data.DataFavoriteResponse;
import com.example.nounours.Data.DataFavorites;
import com.example.nounours.Data.DataMedia;
import com.example.nounours.Data.DataSessionId;
import com.example.nounours.Data.DataToken;
import com.example.nounours.Interfaces.RetrofitAPI;
import com.example.nounours.Interfaces.APIService;
import com.example.nounours.Favorites.FavoritesContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesController {
    APIService service = RetrofitAPI.getRetrofit();
    String sessionId;
    String _token;
    int account_id;

    public String getToken() {
        Call<DataToken> call = service.getToken("d3a6973dd4a2b15cbcda2963be1fd795");

        call.enqueue(new Callback<DataToken>() {
            @Override
            public void onResponse(Call<DataToken> call, Response<DataToken> response) {
                if (response.code() == 200) {
                    _token = response.body().token;
                    Log.d("588", response.body().token);
                }
            }

            @Override
            public void onFailure(Call<DataToken> call, Throwable t) {
                _token = "";
            }
        });
        return (_token);
    }

    public String getSessionId(String token) {
        Call<DataSessionId> call = service.getSessionId("d3a6973dd4a2b15cbcda2963be1fd795", token);

        call.enqueue(new Callback<DataSessionId>() {
            @Override
            public void onResponse(Call<DataSessionId> call, Response<DataSessionId> response) {
                if (response.body().success) {

                    sessionId = response.body().sessionId;
                }
            }

            @Override
            public void onFailure(Call<DataSessionId> call, Throwable t) {
                sessionId = null;
            }
        });

        return (sessionId);
    }

    public int getAccountID(String session_id) {
        Call<DataAccount> call = service.getAccount("d3a6973dd4a2b15cbcda2963be1fd795", session_id);

        call.enqueue(new Callback<DataAccount>() {
            @Override
            public void onResponse(Call<DataAccount> call, Response<DataAccount> response) {
                if (response.code() == 200) {
                    account_id = response.body().id;
                }
            }

            @Override
            public void onFailure(Call<DataAccount> call, Throwable t) {
                account_id = 0;
            }
        });
        return (account_id);
    }

    public void getFavorites(Integer page, FavoritesContent content_ptr, String session, int accountId) {
        Call<DataFavorites> call = service.getFavorites(accountId, "d3a6973dd4a2b15cbcda2963be1fd795", session, page.intValue());

        call.enqueue(new Callback<DataFavorites>() {
            @Override
            public void onResponse(Call<DataFavorites> call, Response<DataFavorites> response) {
                content_ptr.setItems(response.body());
            }

            @Override
            public void onFailure(Call<DataFavorites> call, Throwable t) {
                // Error
            }
        });
    }

    public void postFavorites(int account_id, String sessionId, String media_type, int media_id, boolean favorite) {
        DataMedia media = new DataMedia(media_type, media_id, favorite);
        Call<DataFavoriteResponse> call = service.postFavorites(account_id, "d3a6973dd4a2b15cbcda2963be1fd795", sessionId, media);

        call.enqueue(new Callback<DataFavoriteResponse>() {
            @Override
            public void onResponse(Call<DataFavoriteResponse> call, Response<DataFavoriteResponse> response) {
                if (response.code() == 200) {
                    Log.d("1", response.message());
                }
            }

            @Override
            public void onFailure(Call<DataFavoriteResponse> call, Throwable t) {

            }
        });
    }
}