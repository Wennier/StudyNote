package com.example.wennier_r.projectitem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wennier_r.projectitem.News_ListView.New;
import com.example.wennier_r.projectitem.News_ListView.NewsAdapter;
import com.example.wennier_r.projectitem.R;
import com.example.wennier_r.projectitem.my_activity.NewsContentActivity;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetCallback;
import cn.bmob.v3.listener.GetListener;

/**
 * Created by Wennier_R on 2017/6/10.
 */

public class NewsFragment extends Fragment {

    private static final String TAG = "NewsFragment";
    private ListView mNewsListView = null;  //显示新闻的listview
    private List<JavaBean> newData = null;       //新闻的数据
    private NewsAdapter mNewsAdapter = null; //适配器


    public static NewsFragment getInstance() {
        return new NewsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //bmob5
        Bmob.initialize(getContext(), "fcd825e6381e9647ff71398d4d5371ac");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_news, container, false);
        initView_listView(view);
        queryAll();
        return view;
    }

    public void queryAll() {
        BmobQuery<JavaBean> query = new BmobQuery<>();
        query.findObjects(getActivity(), new FindListener<JavaBean>() {
            @Override
            public void onSuccess(final List<JavaBean> list) {
                Log.i(TAG, "onSuccess: list size " + list.size());
                for (JavaBean javaBean : list) {
                    Log.i(TAG, "onSuccess: " + javaBean.getTitle());
                    Log.i(TAG, "onSuccess: " + javaBean.getContent());
                    Log.i(TAG, "onSuccess: " + javaBean.getImage());

                }
                newData.clear();
                newData.addAll(list);
                mNewsAdapter.notifyDataSetChanged();

                mNewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        JavaBean data = list.get(position);
                        Intent intent = new Intent(getActivity(), NewsContentActivity
                                .class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onError(int i, String s) {
                Log.i(TAG, "onError: " + s);
            }
        });
    }


    //初始化listview
    public void initView_listView(View view) {
        this.newData = new ArrayList<>();
        this.mNewsListView = (ListView) view.findViewById(R.id.new_list);
        this.mNewsAdapter = new NewsAdapter(getActivity(), R.layout.newsitem, newData);
        this.mNewsListView.setAdapter(mNewsAdapter);
    }
}
