package com.example.nounours.Controllers;

import android.util.Log;

import com.example.nounours.Data.DataSearchList;
import com.example.nounours.Data.DataSearch;
import com.example.nounours.Interfaces.RetrofitAPI;
import com.example.nounours.Interfaces.APIService;
import com.example.nounours.Research.ResearchContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResearchController {
    APIService service = RetrofitAPI.getRetrofit();

    public void getResearch(String text, ResearchContent content_ptr) {
        Call<DataSearch> call = service.getSearch("d3a6973dd4a2b15cbcda2963be1fd795", text);

        call.enqueue(new Callback<DataSearch>() {
            @Override
            public void onResponse(Call<DataSearch> call, Response<DataSearch> response) {
                content_ptr.setItems(response.body());
            }

            @Override
            public void onFailure(Call<DataSearch> call, Throwable t) {
            }
        });
    }
}
