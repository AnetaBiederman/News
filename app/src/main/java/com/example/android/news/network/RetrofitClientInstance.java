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
     */
    private static final String BASE_URL = "https://newsapi.org/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {

        Gson gson = new GsonBuilder().
                setDateFormat("yyyy-MM-dd").
                create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }

    /**
     * Get data service
     *
     * @return data Service
     */
    public static GetDataService getDataService() {
        return getRetrofitInstance().create(GetDataService.class);
    }
}
