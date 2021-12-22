package com.example.nounours.Controllers;

import com.example.nounours.Data.DataDiscover;
import com.example.nounours.Interfaces.RetrofitAPI;
import com.example.nounours.Interfaces.APIService;
import com.example.nounours.Discover.DiscoverContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DiscoverController {
    APIService service = RetrofitAPI.getRetrofit();

    public void getDiscover(Integer page, DiscoverContent content_ptr) {
        Call<DataDiscover> call = service.getDiscover("d3a6973dd4a2b15cbcda2963be1fd795", page.intValue());
        // final DataDiscover[] res = {new DataDiscover()};

        call.enqueue(new Callback<DataDiscover>() {
            @Override
            public void onResponse(Call<DataDiscover> call, Response<DataDiscover> response) {
                // res[0] = response.body();
                content_ptr.setItems(response.body());
            }

            @Override
            public void onFailure(Call<DataDiscover> call, Throwable t) {
            }
        });
    }
}
