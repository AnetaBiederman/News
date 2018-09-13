package com.example.android.news;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.news.adapter.ViewPagerAdapter;
import com.example.android.news.fragment.FragmentABC;
import com.example.android.news.fragment.FragmentCNN;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tablayout_id)
    TabLayout tabLayout;
    @BindView(R.id.viewpage_id)
    ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentCNN(), getString(R.string.ccn_news));
        viewPagerAdapter.addFragment(new FragmentABC(), getString(R.string.abc_news));

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
