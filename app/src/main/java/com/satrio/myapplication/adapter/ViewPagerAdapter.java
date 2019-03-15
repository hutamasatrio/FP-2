package com.satrio.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.satrio.myapplication.fragment.Fragment1;
import com.satrio.myapplication.fragment.Fragment2;
import com.satrio.myapplication.fragment.Fragment3;
import com.satrio.myapplication.fragment.Fragment5;


public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            case 2:
                return new Fragment3();
            case 3:
                return new Fragment5();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }


}
