package com.example.android.news;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.news.adapter.NewsAdapter;
import com.example.android.news.model.News;
import com.example.android.news.model.NewsList;
import com.example.android.news.network.GetDataService;
import com.example.android.news.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private List<News> newsList;
    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading Data.. Please wait...");
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();

        //Creating an object of our api interface
        GetDataService api = RetrofitClientInstance.getDataService();

         //Calling JSON
        Call<NewsList> call = api.getAllCNNNews();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                //Dismiss Dialog
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    newsList = response.body().getArticles();
                    recyclerView = findViewById(R.id.customRecyclerView);
                    adapter = new NewsAdapter(context, newsList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}
