package com.example.wennier_r.projectitem.News_ListView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wennier_r.projectitem.fragment.IndexFragment;
import com.example.wennier_r.projectitem.fragment.MyFragment;
import com.example.wennier_r.projectitem.fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wennier_R on 2017/6/10.
 */

public class ContentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> mTitles = new ArrayList<String>();

    public ContentAdapter(FragmentManager fm) {
        super(fm);
        mFragmentList.add(IndexFragment.getInstance());
        //你这里顺序写反了。。。。。
        mFragmentList.add(NewsFragment.getInstance());
        mFragmentList.add(MyFragment.getInstance());
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getCount() {

        return mFragmentList.size();
    }
}
