package piashsotware.ltd.movietune.adapter;



import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentStatePagerAdapter;

import piashsotware.ltd.movietune.fragment.MovieFragment;

/**
 * Created by piash on 11/24/16.
 */

public class TabFragmentPageAdapter extends FragmentStatePagerAdapter {

    private String tabTitles[] = new String[] { "New Release", "Top Rated" ,"Upcomming"};

    public TabFragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return new MovieFragment().newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
