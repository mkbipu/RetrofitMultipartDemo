package com.example.user.movietune.fragment;

import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.movietune.R;
import com.example.user.movietune.activities.MainActivity;
import com.example.user.movietune.adapter.MoviePagerAdapter;

/**
 * Created by User on 4/11/2018.
 */

public class MainFragment extends Fragment {
    private MoviePagerAdapter moviePagerAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public MainFragment(){

//        public empty method........
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_fragment, container,false);

        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.view_pager);


        Toolbar toolbar = view.findViewById(R.id.tool_bar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        moviePagerAdapter = new MoviePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(moviePagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

return view;
    }

}
