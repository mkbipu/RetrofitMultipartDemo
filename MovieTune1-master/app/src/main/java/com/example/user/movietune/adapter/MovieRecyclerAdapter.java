package com.example.user.movietune.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.movietune.R;
import com.example.user.movietune.model.subdata.ResultsItem;

import java.util.List;

/**
 * Created by User on 4/11/2018.
 */

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieviewHolder> {

    private Context mContext;
    private List<ResultsItem> mResultItemList;
    private RVClickListener mRVClickListener;

    public MovieRecyclerAdapter(Context mContext, List<ResultsItem> mResultItemList) {
        this.mContext = mContext;
        this.mResultItemList = mResultItemList;
    }

    @NonNull
    @Override
    public MovieviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_layout, parent, false);
        return new MovieviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieviewHolder holder, int position) {

        Glide.with(mContext)
                .load("http://image.tmdb.org/t/p/w500" + mResultItemList.get(position).getPosterPath())
                .thumbnail(0.1f)
                .into(holder.moviePoster);

    }

    @Override
    public int getItemCount() {
        return mResultItemList.size();
    }

    public void setOnItemClickListener(RVClickListener myClickListener) {
        this.mRVClickListener = myClickListener;
    }

    public interface RVClickListener {
        void onItemClick(int position, View v);
    }

    public class MovieviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView moviePoster;

        public MovieviewHolder(View itemView) {
            super(itemView);

            moviePoster = itemView.findViewById(R.id.movie_img);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mRVClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}