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
 * Created by piash on 11/24/16.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{
    private Context mContext;
    private List<InformationModel> mInformationList;
    private RVClickListener mRVClickListener;

    public MovieAdapter(Context mContex, List<InformationModel> mStringList) {
        this.mContext = mContex;
        this.mInformationList = mStringList;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_adapter, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {



        Glide.with(mContext)
                .load("http://image.tmdb.org/t/p/w500"+ mInformationList.get(position).getPoster_path())
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

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView mImageViewMoviePoster;
        public MovieViewHolder(View itemView) {
            super(itemView);
            mImageViewMoviePoster = (ImageView)itemView.findViewById(R.id.imageViewForMovie);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mRVClickListener.onItemClick(getAdapterPosition(), view);
        }
    }
}
