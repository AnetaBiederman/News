package com.example.android.news.fragment;

import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.news.R;
import com.example.android.news.adapter.NewsAdapter;
import com.example.android.news.model.News;
import com.example.android.news.model.NewsList;
import com.example.android.news.network.GetDataService;
import com.example.android.news.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentCNN extends Fragment {

    View v;
    private List<News> newsList;
    private NewsAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    Context context;

    public FragmentCNN () {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment, container, false);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();

        progressDialog = new ProgressDialog(getActivity());
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

                if (response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    newsList = response.body().getArticles();
                    recyclerView = v.findViewById(R.id.customRecyclerView);
                    adapter = new NewsAdapter(context, newsList);
                    RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(eLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                progressDialog.dismiss();

            }
        });}
}
