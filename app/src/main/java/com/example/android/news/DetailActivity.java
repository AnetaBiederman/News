package com.example.android.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Get the properties of the Place Object from the intent
        Bundle bundle = getIntent().getExtras();

        String title = bundle.getString("title");
        String date = bundle.getString("publishedAt");
        String author = bundle.getString("author");
        String content = bundle.getString("content");

        TextView tvTitle = findViewById(R.id.detail_title);
        ImageView imageView = findViewById(R.id.detail_picture);
        TextView tvDate = findViewById(R.id.detail_date);
        TextView tvAuthor = findViewById(R.id.detail_author);
        TextView tvContent = findViewById(R.id.detail_content);

        tvTitle.setText(title);
        tvDate.setText(date);
        tvAuthor.setText(author);
        tvContent.setText(content);

        Intent getImage = getIntent();
        String gettingImageUrl = getImage.getStringExtra("urlToImage");
        Picasso.with(DetailActivity.this).load(gettingImageUrl).into(imageView);

       }
}
