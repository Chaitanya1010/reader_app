package com.tetalichaitanya.reader_app_demo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by tetalichaitanya on 30/7/16.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter
{
    protected ArrayList<First_Fragment> first_fragments = new ArrayList<First_Fragment>();

    public MyPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int pos)
    {
        Log.d("Frag cycle", "before getItem stat");
        return first_fragments.get(pos);

    }

    @Override
    public int getCount() {
        return first_fragments.size();
    }
}
