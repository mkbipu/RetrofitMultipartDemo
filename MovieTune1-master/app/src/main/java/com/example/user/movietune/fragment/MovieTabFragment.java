package com.example.user.movietune.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.user.movietune.R;
import com.example.user.movietune.adapter.MovieRecyclerAdapter;
import com.example.user.movietune.api.ApiClient;
import com.example.user.movietune.api.MovieInterface;
import com.example.user.movietune.model.NewReleaseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 4/11/2018.
 */

public class MovieTabFragment extends Fragment {

    private final String TAG = "MovieTabFragment";
    private MovieInterface mApiMovieInterface;
    private RecyclerView mMovieRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MovieRecyclerAdapter mMovieAdapter;
    private ProgressBar mProgressBar;
    private int mAdapterPosition;
    private Bundle mBundleSend;

    public MovieTabFragment(){

//        empty constructor
    }

    public MovieTabFragment newInstance(int position) {
        // Required empty public constructor
        MovieTabFragment fragment = new MovieTabFragment();
        fragment.mAdapterPosition = position;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_movie_fragment,container,false);

        Retrofit retrofit = ApiClient.getInstance(getActivity());
        mApiMovieInterface = retrofit.create(MovieInterface.class);
        mMovieRecyclerView = view.findViewById(R.id.recycler_view);
        mProgressBar = view.findViewById(R.id.progress_bar);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mMovieRecyclerView.setLayoutManager(mLayoutManager);
        mBundleSend = new Bundle();

        if (mAdapterPosition==0){
            newReleaseMovie();
        }else
        if (mAdapterPosition==1){
            tpRatedMovie();
        }else
        if (mAdapterPosition==2){
            upComingMovie();
        }


        return view;
    }

    private void newReleaseMovie(){
        mApiMovieInterface.newRelieseMovieNetworkCall().enqueue(new Callback<NewReleaseData>() {
            @Override
            public void onResponse(Call<NewReleaseData> call, final Response<NewReleaseData> response) {
                if (response.isSuccessful()){
                    mProgressBar.setVisibility(View.GONE);
                    mMovieRecyclerView.setVisibility(View.VISIBLE);
                   mMovieAdapter = new MovieRecyclerAdapter(getActivity(), response.body().getResults());
                   mMovieRecyclerView.setAdapter(mMovieAdapter);
                    mMovieAdapter.setOnItemClickListener(new MovieRecyclerAdapter.RVClickListener() {
                        @Override
                        public void onItemClick(int position, View v) {
                            mBundleSend.putInt("movieId", response.body().getResults().get(position).getId());
                            MovieDetailFragment fragment = new MovieDetailFragment();
                            fragment.setArguments(mBundleSend);
                            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.activity_main, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<NewReleaseData> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString() );
            }
        });
    }
    private void tpRatedMovie(){
        mApiMovieInterface.topRatedMovieNetworkCall().enqueue(new Callback<NewReleaseData>() {
            @Override
            public void onResponse(Call<NewReleaseData> call, final Response<NewReleaseData> response) {
                if (response.isSuccessful()){
                    mProgressBar.setVisibility(View.GONE);
                    mMovieRecyclerView.setVisibility(View.VISIBLE);
                   mMovieAdapter = new MovieRecyclerAdapter(getActivity(), response.body().getResults());
                   mMovieRecyclerView.setAdapter(mMovieAdapter);
                    mMovieAdapter.setOnItemClickListener(new MovieRecyclerAdapter.RVClickListener() {
                        @Override
                        public void onItemClick(int position, View v) {
                            mBundleSend.putInt("movieId", response.body().getResults().get(position).getId());
                            MovieDetailFragment fragment = new MovieDetailFragment();
                            fragment.setArguments(mBundleSend);
                            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.activity_main, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<NewReleaseData> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString() );
            }
        });
    }

    private void upComingMovie(){
        mApiMovieInterface.upCommingMovieNetworkCall().enqueue(new Callback<NewReleaseData>() {
            @Override
            public void onResponse(Call<NewReleaseData> call, final Response<NewReleaseData> response) {
                if (response.isSuccessful()){
                    mProgressBar.setVisibility(View.GONE);
                    mMovieRecyclerView.setVisibility(View.VISIBLE);
                   mMovieAdapter = new MovieRecyclerAdapter(getActivity(), response.body().getResults());
                   mMovieRecyclerView.setAdapter(mMovieAdapter);
                    mMovieAdapter.setOnItemClickListener(new MovieRecyclerAdapter.RVClickListener() {
                        @Override
                        public void onItemClick(int position, View v) {
                            Log.e(TAG, "onItemClick: "+response.body().getResults().get(position).getId() );
                            mBundleSend.putInt("movieId", response.body().getResults().get(position).getId());
                            MovieDetailFragment fragment = new MovieDetailFragment();
                            fragment.setArguments(mBundleSend);
                            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.activity_main, fragment);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<NewReleaseData> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.toString() );
            }
        });
    }
}
