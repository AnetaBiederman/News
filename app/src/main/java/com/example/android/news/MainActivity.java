package com.example.android.news;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.RecyclerView;

import com.example.android.news.adapter.NewsAdapter;
import com.example.android.news.adapter.ViewPagerAdapter;
import com.example.android.news.fragment.FragmentABC;
import com.example.android.news.fragment.FragmentCNN;
import com.example.android.news.model.News;

import java.util.List;



public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

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

        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpage_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentCNN(), "CCN news");
        viewPagerAdapter.addFragment(new FragmentABC(), "ABC news");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
