package com.example.user.movietune.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import com.example.user.movietune.fragment.MovieTabFragment;

/**
 * Created by User on 4/11/2018.
 */

public class MoviePagerAdapter extends FragmentStatePagerAdapter {
    private String tabTitle[] = new String[]  {"New Release", "Top Rated", "Up Coming"};

    public MoviePagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return new MovieTabFragment().newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitle.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
