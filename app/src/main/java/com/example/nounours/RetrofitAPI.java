package com.example.nounours;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.example.nounours.APIService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAPI {

    static APIService service = null;

    public static APIService getRetrofit() {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm").create();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(APIService.class);

        return(service);
    }
}
