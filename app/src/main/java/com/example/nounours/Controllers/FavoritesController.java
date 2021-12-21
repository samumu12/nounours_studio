package com.example.nounours.Controllers;

import android.util.Log;

import com.example.nounours.Data.DataAccount;
import com.example.nounours.Data.DataFavorites;
import com.example.nounours.Data.DataSessionId;
import com.example.nounours.RetrofitAPI;
import com.example.nounours.APIService;
import com.example.nounours.content.FavoritesContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavoritesController {
    APIService service = RetrofitAPI.getRetrofit();
    String sessionId;
    int account_id;

    public String getSessionId() {
        LoginController controller = new LoginController();
        String token = controller.getToken();

        Call<DataSessionId> call = service.getSessionId("d3a6973dd4a2b15cbcda2963be1fd795", token);

        call.enqueue(new Callback<DataSessionId>() {
            @Override
            public void onResponse(Call<DataSessionId> call, Response<DataSessionId> response) {
                if (response.body().success) {
                    Log.d("2", response.toString());
                    sessionId = response.body().sessionId;
                }
            }

            @Override
            public void onFailure(Call<DataSessionId> call, Throwable t) {
                Log.d("3", t.toString());
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
                Log.d("1", response.toString());
                account_id = response.body().id;
            }

            @Override
            public void onFailure(Call<DataAccount> call, Throwable t) {
                account_id = 0;
            }
        });
        return (account_id);
    }

    public void getFavorites(Integer page, FavoritesContent content_ptr) {
        String session = getSessionId();
        int account_id = getAccountID(session);
        Call<DataFavorites> call = service.getFavorites(account_id, "d3a6973dd4a2b15cbcda2963be1fd795", session, page.intValue());

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
}