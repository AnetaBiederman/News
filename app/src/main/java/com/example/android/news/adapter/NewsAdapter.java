package com.example.android.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.news.DetailActivity;
import com.example.android.news.R;
import com.example.android.news.model.News;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<News> newsList;
    private Context context;

    public NewsAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title_tv)
        TextView txtTitle;
        @BindView(R.id.date_tv)
        TextView txtDate;
        @BindView(R.id.cover_image)
        ImageView coverImage;

        public NewsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("title", newsList.get(getAdapterPosition()).getTitle());
                    intent.putExtra("urlToImage", newsList.get(getAdapterPosition()).getUrlToImage());
                    intent.putExtra("publishedAt", newsList.get(getAdapterPosition()).getPublishedAt());
                    intent.putExtra("author", newsList.get(getAdapterPosition()).getAuthor());
                    intent.putExtra("content", newsList.get(getAdapterPosition()).getContent());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new NewsViewHolder(view);
    }

    // Pairing View with right information.
    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        News articles = newsList.get(position);
        holder.txtTitle.setText(articles.getTitle());
        holder.txtDate.setText(articles.getPublishedAt());

      // If image is not available use placeholder image
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(newsList.get(position).getUrlToImage())
                .placeholder((R.drawable.ic_launcher_background))
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

}
