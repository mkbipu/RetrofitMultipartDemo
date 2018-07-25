package com.example.user.movietune.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.movietune.R;
import com.example.user.movietune.activities.MainActivity;
import com.example.user.movietune.adapter.SimilarMovieAdapter;
import com.example.user.movietune.api.ApiClient;
import com.example.user.movietune.api.MovieInterface;
import com.example.user.movietune.model.MovieDetailData;
import com.example.user.movietune.model.NewReleaseData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by User on 4/11/2018.
 */

public class MovieDetailFragment extends Fragment {

    private final String TAG = "MovieDetail";
    private MovieInterface mApiMovieInterface;
    private RecyclerView mSimilarMovieRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private SimilarMovieAdapter mSimilarMovieAdapter;
    private TextView mTextViewOverView;
    private TextView mTextViewMovieTitle;
    private TextView mTextViewMoviName;
    private TextView mTextViewVoteAvg;
    private TextView mTextViewPopularity;
    private ImageView mImageViewDetailPoster;
    private TextView mTextViewReleaseYear;
    private TextView mTextViewMovieCategory;
    private TextView mTextViewPcompany;
    private TextView mtextViewPCountry;
    private TextView mTextViewBudget;
    private TextView mTextViewLanguage;
    private Bundle mBundleForData;
    public MovieDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.moviedetail_layout, container, false);
        mSimilarMovieRecyclerView = (RecyclerView)view.findViewById(R.id.similarMovieRecyclerView);
        mTextViewOverView = (TextView)view.findViewById(R.id.textViewOverView);
        mTextViewMovieTitle = (TextView)view.findViewById(R.id.textViewMovieTitle);
        mTextViewMoviName = (TextView)view.findViewById(R.id.textViewMovieName);
        mImageViewDetailPoster = (ImageView)view.findViewById(R.id.detailImage);
        mTextViewVoteAvg = (TextView)view.findViewById(R.id.textViewVoteAvg);
        mTextViewPopularity = (TextView)view.findViewById(R.id.textViewPopularity);
        mTextViewReleaseYear = (TextView)view.findViewById(R.id.textViewReleaseYear);
        mTextViewMovieCategory = (TextView)view.findViewById(R.id.textViewMoiveCategory);
        mTextViewPcompany = (TextView)view.findViewById(R.id.textViewPCompanyName);
        mtextViewPCountry = (TextView)view.findViewById(R.id.textViewPCountry);
        mTextViewBudget = (TextView)view.findViewById(R.id.textViewBudget);
        mTextViewLanguage = (TextView)view.findViewById(R.id.textViewLanguage);

        Toolbar toolbar = (Toolbar)view.findViewById(R.id.tool_bar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        Retrofit retrofit = ApiClient.getInstance(getActivity());
        mApiMovieInterface = retrofit.create(MovieInterface.class);
        mBundleForData = new Bundle();
        mBundleForData = getArguments();
        detailInformation();
        similarMovie();

        return view;
    }

    private void detailInformation(){
        mApiMovieInterface.movieDetailNetworkCall(getArguments().getInt("movieId")).enqueue(
                new Callback<MovieDetailData>() {
                    @Override
                    public void onResponse(Call<MovieDetailData> call, Response<MovieDetailData> response) {
                        if (response.isSuccessful()){


                            mTextViewOverView.setText(response.body().getOverview());
                            mTextViewMovieTitle.setText(response.body().getOriginalTitle());
                            mTextViewMoviName.setText(response.body().getTitle());
                            mTextViewVoteAvg.setText(String.format("%.1f", response.body().getVoteAverage()));
                            mTextViewPopularity.setText(String.format("%.0f", response.body().getPopularity())+"%");
                            mTextViewPcompany.setText(response.body().getProductionCompanies().get(0).getName());
                            mtextViewPCountry.setText(response.body().getProductionCountries().get(0).getName());
                            mTextViewBudget.setText("$ "+String.valueOf(response.body().getBudget()));
                            mTextViewLanguage.setText(response.body().getOriginalLanguage());
                            String year[] = response.body().getReleaseDate().split("-");
                            mTextViewReleaseYear.setText("("+year[0]+")");

                            for (int i = 0; i < response.body().getGenres().size(); i++) {

                                if (i <response.body().getGenres().size() -1 ){
                                    mTextViewMovieCategory.append(response.body().getGenres().get(i).getName()+", ");
                                }else {
                                    mTextViewMovieCategory.append(response.body().getGenres().get(i).getName());

                                }
                            }
                            Log.e(TAG, "onResponse: image "+response.body().getPosterPath() );
                            Glide.with(getActivity())
                                    .load("http://image.tmdb.org/t/p/w500"+ response.body().getBackdropPath())
                                    .thumbnail(0.1f)
                                    .into(mImageViewDetailPoster);
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieDetailData> call, Throwable t) {

                        Log.e(TAG, "onFailure: "+t.toString() );
                    }
                }
        );
    }

    private void similarMovie(){

        mSimilarMovieRecyclerView.setHasFixedSize(true);
        mLayoutManager =  new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mSimilarMovieRecyclerView.setLayoutManager(mLayoutManager);
        mApiMovieInterface.similarMovieNetworkCall(getArguments().getInt("movieId")).enqueue(
                new Callback<NewReleaseData>() {
                    @Override
                    public void onResponse(Call<NewReleaseData> call, final Response<NewReleaseData> response) {

                        if (response.isSuccessful()){

                            mSimilarMovieAdapter = new SimilarMovieAdapter(getActivity(), response.body().getResults());
                            mSimilarMovieRecyclerView.setAdapter(mSimilarMovieAdapter);
                            mSimilarMovieAdapter.setOnItemClickListener(
                                    new SimilarMovieAdapter.RVClickListener() {
                                        @Override
                                        public void onItemClick(int position, View v) {
                                            mBundleForData.putInt("movieId", response.body().getResults().get(position).getId());
                                            MovieDetailFragment fragment = new MovieDetailFragment();
                                            fragment.setArguments(mBundleForData);
                                            FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
                                            fragmentTransaction.replace(R.id.activity_main, fragment);
                                            fragmentTransaction.addToBackStack(null);
                                            fragmentTransaction.commit();
                                        }
                                    }
                            );
                        }
                    }

                    @Override
                    public void onFailure(Call<NewReleaseData> call, Throwable t) {

                        Log.e(TAG, "onFailure: "+t.toString() );
                    }
                }
        );

    }

}
