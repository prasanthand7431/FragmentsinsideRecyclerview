package com.example.gspl.bottomnavigation_fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> firstfrag = new ArrayList<>();
    private final List<String> firsttitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return firstfrag.get(position);
    }

    @Override
    public int getCount() {
        return firsttitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
       return firsttitle.get(position);
    }

    public void AddFragment(Fragment fragment, String title){

        firstfrag.add(fragment);
        firsttitle.add(title);
    }
}
