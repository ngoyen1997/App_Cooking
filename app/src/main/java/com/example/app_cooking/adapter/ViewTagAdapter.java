package com.example.app_cooking.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.app_cooking.fragment.Cooking_Fragment;

import java.util.ArrayList;
import java.util.List;

public class ViewTagAdapter extends FragmentStatePagerAdapter {
    List<Cooking_Fragment> listFrag = new ArrayList<>();
    List<String> listTitle = new ArrayList<>();


    public ViewTagAdapter(FragmentManager fm) {
        super(fm);


    }

    public void addFrag(Cooking_Fragment fragment,String title){

        listFrag.add(fragment);
        listTitle.add(title);
    }

    @Override
    public Fragment getItem(int i) {
        return listFrag.get(i);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }
}
