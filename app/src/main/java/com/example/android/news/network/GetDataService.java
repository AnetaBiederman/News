package com.example.android.news.network;

import com.example.android.news.model.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    // The endpoints are defined inside of an interface using special retrofit
    // annotations to encode details about the parameters and request method.
    // URL for news is: https://newsapi.org/v2/everything?sources=cnn&apiKey=16cb9678f5f14cf699cb6913bab2564c
    @GET("/v2/everything?sources=cnn&apiKey=16cb9678f5f14cf699cb6913bab2564c")
    Call<List<News>> getAllNews();
}
