package com.example.android.news.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * To issue network requests to a REST API with Retrofit,
 * we need to create an instance using the Retrofit.Builder class
 * and configure it with a base URL
 */
public class RetrofitClientInstance {

    /**
     * root URLS= of API which will be called
     * URL for news is: https://newsapi.org/v2/everything?sources=cnn&apiKey=16cb9678f5f14cf699cb6913bab2564c
     */
    private static final String BASE_URL = "https://newsapi.org/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get data service
     * @return data Service
     */
    public static GetDataService getDataService() {
        return getRetrofitInstance().create(GetDataService.class);
    }
}
