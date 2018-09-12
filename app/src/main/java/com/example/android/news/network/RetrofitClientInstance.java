package com.example.android.news.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


//To issue network requests to a REST API with Retrofit,
// we need to create an instance using the Retrofit.Builder class
// and configure it with a base URL
public class RetrofitClientInstance {

    private static Retrofit retrofit;
    // base URL of API which will be called
    // URL for news is: https://newsapi.org/v2/everything?sources=cnn&apiKey=16cb9678f5f14cf699cb6913bab2564c
    private static final String BASE_URL = "https://newsapi.org";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
