package com.example.wennier_r.projectitem.my_activity;

import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wennier_r.projectitem.fragment.JavaBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Wennier_R on 2017/6/13.
 */

public class NewsContentActivity extends AppCompatActivity {
    private static final String TAG = "NewsContentActivity";
    private JavaBean data;
    private int position;
    private ImageView image_click = null;
    private TextView title_click = null;
    private TextView content_click = null;
    private ListView mNewsListView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.wennier_r.projectitem.R.layout.news_content);
        data = (JavaBean) getIntent().getSerializableExtra("data");
        initViews();
    }

    private void initViews() {
        BmobQuery<JavaBean> query = new BmobQuery<>();
        query.findObjects(this, new FindListener<JavaBean>() {
            @Override
            public void onSuccess(List<JavaBean> list) {
               data = list.get(position);
            }

            @Override
            public void onError(int i, String s) {

            }
        });
        this.image_click = (ImageView) findViewById(com.example.wennier_r.projectitem.R.id.news_image);
        this.title_click = (TextView) findViewById(com.example.wennier_r.projectitem.R.id.news_title);
        this.content_click = (TextView) findViewById(com.example.wennier_r.projectitem.R.id.news_content);
        this.mNewsListView = (ListView) findViewById(com.example.wennier_r.projectitem.R.id.new_list);
        Glide.with(this).load(data.getImage()).into(image_click);
//        image_click.setImageURI(Uri.parse(data.getImage()));
        title_click.setText(data.getTitle());
        content_click.setText(data.getContent());
    }
}
