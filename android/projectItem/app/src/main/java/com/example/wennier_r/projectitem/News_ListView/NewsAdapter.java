package com.example.wennier_r.projectitem.News_ListView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wennier_r.projectitem.R;
import com.example.wennier_r.projectitem.fragment.JavaBean;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Wennier_R on 2017/6/12.
 */

public class NewsAdapter extends ArrayAdapter {
    private int newsPicResourceID;      //新闻图片资源ID

    private List<JavaBean> list;
    private Context context;

    public NewsAdapter(Context context, int resource, List<JavaBean> objects){
        super(context,resource,objects);
        this.context = context;
        this.newsPicResourceID = resource;
        list = objects;
    }

    public void setList(List<JavaBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JavaBean news = (JavaBean) getItem(position);
        ViewHolder viewHolder;
        View view;
        if (convertView == null) {
            /*view = View.inflate(getContext(), newsPicResourceID, null);*/
            viewHolder = new ViewHolder();
            convertView = View.inflate(getContext(),R.layout.newsitem,null);
        /*    viewHolder.mNewsPic = (ImageView) view.findViewById(R.id.newsIcon);
            viewHolder.mNewsTitle = (TextView) view.findViewById(R.id.newsTitle);
            viewHolder.mNewsBody = (TextView) view.findViewById(R.id.newsBody);*/
            viewHolder.mNewsPic = (ImageView) convertView.findViewById(R.id.newsIcon);
            viewHolder.mNewsTitle = (TextView) convertView.findViewById(R.id.newsTitle);
            viewHolder.mNewsBody = (TextView) convertView.findViewById(R.id.newsBody);
            convertView.setTag(viewHolder);
        } else {
            /*view = convertView;*/
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(context)
                .load(news.getImage())
                .into(viewHolder.mNewsPic)
        ;
        viewHolder.mNewsTitle.setText(news.getTitle());
        viewHolder.mNewsBody.setText(news.getContent());
        return convertView;
    }

    //提高listview 的运行效率 使用视图缓冲区
    private class ViewHolder{
        public ImageView mNewsPic ;
        public TextView mNewsTitle ;
        public TextView mNewsBody ;
    }
}
