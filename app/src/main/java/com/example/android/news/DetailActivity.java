package com.example.android.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detail_title)
    TextView tvTitle;
    @BindView(R.id.detail_date)
    TextView tvDate;
    @BindView(R.id.detail_author)
    TextView tvAuthor;
    @BindView(R.id.detail_content)
    TextView tvContent;
    @BindView(R.id.detail_picture)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        //Get the properties of the Place Object from the intent
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String date = bundle.getString("publishedAt");
        String author = bundle.getString("author");
        String content = bundle.getString("content");

        // Set content to correct views
        tvTitle.setText(title);
        tvDate.setText(date);
        tvAuthor.setText(author);
        tvContent.setText(content);

        Intent getImage = getIntent();
        String gettingImageUrl = getImage.getStringExtra("urlToImage");
        Picasso.with(DetailActivity.this).load(gettingImageUrl).into(imageView);

       }
}
