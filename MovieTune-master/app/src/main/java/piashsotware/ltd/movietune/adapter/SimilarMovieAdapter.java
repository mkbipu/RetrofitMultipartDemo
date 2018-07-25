package piashsotware.ltd.movietune.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;

import java.util.List;

import piashsotware.ltd.movietune.R;
import piashsotware.ltd.movietune.datamodel.subdatamodel.InformationModel;

/**
 * Created by piash on 11/25/16.
 */

public class SimilarMovieAdapter extends RecyclerView.Adapter<SimilarMovieAdapter.SimilarViewHolder> {

    private Context mContext;
    private List<InformationModel> mInformationList;
    private RVClickListener mRVClickListener;

    public SimilarMovieAdapter(Context mContext, List<InformationModel> mInformationList) {
        this.mContext = mContext;
        this.mInformationList = mInformationList;
    }

    @Override
    public SimilarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_similarmovie_adapter, parent, false);

        return new SimilarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimilarViewHolder holder, int position) {

        DrawableRequestBuilder<String> thumbnailRequest = Glide
                .with(mContext)
                .load("http://image.tmdb.org/t/p/w500"+ mInformationList.get(position).getPoster_path());
        Glide.with(mContext)
                .load("http://image.tmdb.org/t/p/w500"+ mInformationList.get(position).getPoster_path())
                .thumbnail(thumbnailRequest)
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
