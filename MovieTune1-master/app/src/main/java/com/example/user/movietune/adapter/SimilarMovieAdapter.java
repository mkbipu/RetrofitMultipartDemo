package com.example.user.movietune.adapter;

import android.content.Context;
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

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.SimilarViewHolder> {

    private Context mContext;
    private List<ResultsItem> mInformationList;
    private RVClickListener mRVClickListener;

    public SimilarMovieAdapter(Context mContext, List<ResultsItem> mInformationList) {
        this.mContext = mContext;
        this.mInformationList = mInformationList;
    }

    @Override
    public SimilarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.similarmovie_poster, parent, false);

        return new SimilarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimilarViewHolder holder, int position) {

//       Bui<String> thumnailRequest = Glide
//
//                .with(mContext)
//                .load("http://image.tmdb.org/t/p/w500"+ mInformationList.get(position).getPosterPath());

        Glide.with(mContext)
                .load("http://image.tmdb.org/t/p/w500"+ mInformationList.get(position).getPosterPath())
                .thumbnail(0.1f)
                .into(holder.mImageViewMoviePoster);
    }

    @Override
    public int getItemCount() {
        return mInformationList.size();
    }
    public void setOnItemClickListener(RVClickListener myClickListener) {
        this.mRVClickListener = myClickListener;
    }
    public interface RVClickListener {
        void onItemClick(int position, View v);
    }
    public class SimilarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageViewMoviePoster;
        public SimilarViewHolder(View itemView) {
            super(itemView);
            mImageViewMoviePoster = (ImageView)itemView.findViewById(R.id.imageViewForSimilarMovie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mRVClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
