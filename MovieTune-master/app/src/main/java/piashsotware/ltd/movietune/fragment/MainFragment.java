package piashsotware.ltd.movietune.fragment;


import android.app.Fragment;

import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import piashsotware.ltd.movietune.MainActivity;
import piashsotware.ltd.movietune.R;
import piashsotware.ltd.movietune.adapter.TabFragmentPageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private TabFragmentPageAdapter mAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    public MainFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewPager = (ViewPager)view.findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)view.findViewById(R.id.sliding_tabs);
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        mAdapter = new TabFragmentPageAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        return view;
    }

}
