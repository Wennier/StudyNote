package com.example.wennier_r.projectitem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wennier_r.projectitem.R;
import com.example.wennier_r.projectitem.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wennier_R on 2017/6/10.
 */

public class IndexFragment  extends Fragment{
    private ViewPager viewPager=null;
    private LinearLayout dot_layout = null;
    private ImageButton button;
    private LinearLayout openGitHub;

    private List<Utils> list=new ArrayList<>();

    public static IndexFragment getInstance(){
        return new IndexFragment();
    }


    public void openGitHub(View view){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private Handler handler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            handler.sendEmptyMessageDelayed(0,3000);

        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView =inflater.inflate(R.layout.activity_index,container,false);

        //按钮点击事件
        button= (ImageButton) mView.findViewById(R.id.start__btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                button.setImageResource(R.drawable.starting);
                Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivity(intent);
                Toast.makeText(getContext(),"请开启抢红包辅助功能",Toast.LENGTH_LONG).show();
            }
        });

        viewPager = (ViewPager) mView.findViewById(R.id.viewPager);
        dot_layout = (LinearLayout) mView.findViewById(R.id.dot_layout);
        //给ViewPager填充数据，设置适配器
        viewPager.setAdapter(new MyAdapter());
        //设置ViewPager的pager改变的监听器
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            //只要一直滑动pager就会执行
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            //当Pager页数发生改变时调用该方法
            @Override
            public void onPageSelected(int position) {
                updateTextAndDot();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        list.add(new Utils(R.drawable.banner_img1,"全民抢红包"));
        list.add(new Utils(R.drawable.banner_img2,"全民抢红包"));
        list.add(new Utils(R.drawable.banner_img3,"全民抢红包"));
        // 由于一开始并不会调用OnPageChangeListener()里面的onPageSelected
        updateTextAndDot();
        //设置ViewPager默认选中的页数，设置最大值
        viewPager.setCurrentItem(list.size()*100000);
        // 发送延时消息
        handler.sendEmptyMessageDelayed(0,3000);
        return mView;
    }




    /**
     * //实现轮播图
     */
    class MyAdapter extends PagerAdapter {
        //返回多少页数
        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view = View.inflate(getContext(),R.layout.adapter_list,null);

            FrameLayout imageView = (FrameLayout) view.findViewById(R.id.image);

            imageView.setBackgroundResource(list.get(position%list.size()).getIconResId());

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }
    }
    //动态获取文本和点
    private void updateTextAndDot(){
        int currentItem = viewPager.getCurrentItem()%list.size();
        for(int  i =0;i<dot_layout.getChildCount();i++){
            View childview = dot_layout.getChildAt(i);
            childview.setBackgroundResource(currentItem == i?R.drawable.focus:R.drawable.normal);
        }
    }
    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
