package com.example.nounours.Controllers;

import android.util.Log;

import com.example.nounours.Data.DataDiscover;
import com.example.nounours.RetrofitAPI;
import com.example.nounours.APIService;
import com.example.nounours.content.DiscoverContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverController {
    APIService service = RetrofitAPI.getRetrofit();

    public void getDiscover(Integer page, DiscoverContent content_ptr) {
        Call<DataDiscover> call = service.getDiscover("d3a6973dd4a2b15cbcda2963be1fd795", page.intValue());
        // final DataDiscover[] res = {new DataDiscover()};
        Log.d("17", call.request().toString());

        call.enqueue(new Callback<DataDiscover>() {
            @Override
            public void onResponse(Call<DataDiscover> call, Response<DataDiscover> response) {
                Log.d("15", String.valueOf(response.body()));
                // res[0] = response.body();
                content_ptr.setItems(response.body());
            }

            @Override
            public void onFailure(Call<DataDiscover> call, Throwable t) {
                Log.d("22", t.getLocalizedMessage());
            }
        });
        // return (res[0]);
        // Response<DataDiscover> response;
        // try {
        //     response = call.execute();
        //     return (response.body());
        // } catch (Exception err) {
        //     err.printStackTrace();
        //     return (new DataDiscover());
        // }

    }
}
