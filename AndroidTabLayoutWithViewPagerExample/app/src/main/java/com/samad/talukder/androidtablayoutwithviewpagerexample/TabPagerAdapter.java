package com.samad.talukder.androidtablayoutwithviewpagerexample;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int tabCount = 6;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabViewFragment();
            case 1:
                return new TabViewFragment();
            case 2:
                return new TabViewFragment();
            case 3:
                return new TabViewFragment();
            case 4:
                return new TabViewFragment();
            case 5:
                return new TabViewFragment();
            default:
                return null;
        }
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Home";
            case 1:
                return "Sports";
            case 2:
                return "LifeStyles";
            case 3:
                return "ShowBiz";
            case 4:
                return "Business";
            case 5:
                return "Tech";
        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
