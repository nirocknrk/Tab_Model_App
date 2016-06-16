package temp.mi.com.mimodelapp.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import temp.mi.com.mimodelapp.ui.DemoObjectFragment;

/**
 * Created by Niroshan on 6/15/2016.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();


    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new DemoObjectFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DemoObjectFragment.ARG_OBJECT, position + 1);
        fragment.setArguments(args);
        return fragment;
//        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return 5;
//        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Tab "+position;
//        return mFragmentTitles.get(position);
    }
}
