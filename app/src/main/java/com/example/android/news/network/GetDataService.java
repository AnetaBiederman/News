package com.example.android.news.network;

import com.example.android.news.model.NewsList;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    String API_KEY = "16cb9678f5f14cf699cb6913bab2564c";
    String SOURCE_CNN = "cnn";
    String SOURCE_ABC_NEWS = "abc-news";
    String EVERYTHING = "everything";
    String TOP_HEADLINES = "top-headlines";



    // Retrofit get annotation with our URL
    // And our method that will return us the List of NewsList
    // URL for news is: https://newsapi.org/v2/everything?sources=cnn&apiKey=16cb9678f5f14cf699cb6913bab2564c
    @GET("/v2/" + EVERYTHING + "?sources=" + SOURCE_CNN + "&apiKey=" + API_KEY)
    Call<NewsList> getAllCNNNews();

    @GET("/v2/" + EVERYTHING + "?sources=" + SOURCE_ABC_NEWS + "&apiKey=" + API_KEY)
    Call<NewsList> getAllABCNews();
}
