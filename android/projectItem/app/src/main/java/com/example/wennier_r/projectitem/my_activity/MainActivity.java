package com.example.wennier_r.projectitem.my_activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wennier_r.projectitem.News_ListView.ContentAdapter;
import com.example.wennier_r.projectitem.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    //声明变量（底部菜单）
    private LinearLayout ll_red_packet;
    private LinearLayout ll_news;
    private LinearLayout ll_my;
    private ImageView iv_red_packet;
    private ImageView iv_news;
    private ImageView iv_my;
    private TextView tv_red_packet;
    private TextView tv_news;
    private TextView tv_my;
    //中间内容区域
    private ViewPager content_viewPager;
    //viewPager适配器
    private ContentAdapter menu_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        /**
         * 底部菜单区
         */
        //初始化控件
        initView();
        //初始化底部按钮事件
        initEvent();
    }
    /**
     * 底部菜单区
     */
    //初始化控件
    private void initView(){
        //底部菜单3个Linearlayout
        this.ll_red_packet = (LinearLayout) findViewById(R.id.ll_red_packet);
        this.ll_news = (LinearLayout) findViewById(R.id.ll_news);
        this.ll_my = (LinearLayout) findViewById(R.id.ll_my);

        //底部菜单3个ImageView
        this.iv_red_packet = (ImageView) findViewById(R.id.iv_red_packet);
        this.iv_news = (ImageView) findViewById(R.id.iv_news);
        this.iv_my = (ImageView) findViewById(R.id.iv_my);

        //底部菜单3个TextView
        this.tv_red_packet = (TextView) findViewById(R.id.tv_red_packet);
        this.tv_news = (TextView) findViewById(R.id.tv_news);
        this.tv_my = (TextView) findViewById(R.id.tv_my);

        //中间内容区域viewPager
        this.content_viewPager = (ViewPager) findViewById(R.id.vp_content);

        this.menu_adapter = new ContentAdapter(getSupportFragmentManager());
        content_viewPager.setAdapter(menu_adapter);
    }

    //初始化底部按钮事件
    private void initEvent() {
        //设置按钮监听
        ll_red_packet.setOnClickListener(this);
        ll_news.setOnClickListener(this);
        ll_my.setOnClickListener(this);

        //设置ViewPager滑动监听
        content_viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

        restartButton();

        //当前View被选择的时候，改变底部菜单图片，文字染色
        switch (position){
            case 0:
                iv_red_packet.setImageResource(R.drawable.redpacket);
                tv_red_packet.setTextColor(0xFFA30019);
                break;
            case 1:
                iv_news.setImageResource(R.drawable.news);
                tv_news.setTextColor(0xFFA30019);
                break;
            case 2:
                iv_my.setImageResource(R.drawable.my);
                tv_my.setTextColor(0xFFA30019);
                break;
            default:
                break;

        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        //在每次点击后将所有的底部按钮（ImageView，TextView）颜色改为灰色，然后根据点击着色
        restartButton();

        //ImageView和TextView置为红色，页面随之跳转
        switch (v.getId()){
            case R.id.ll_red_packet:
                iv_red_packet.setImageResource(R.drawable.redpacket);
                tv_red_packet.setTextColor(0xFFA30019);
                content_viewPager.setCurrentItem(0);
                break;
            case R.id.ll_news:
                iv_news.setImageResource(R.drawable.news);
                tv_news.setTextColor(0xFFA30019);
                content_viewPager.setCurrentItem(1);
                break;
            case R.id.ll_my:
                iv_news.setImageResource(R.drawable.my);
                tv_news.setTextColor(0xFFA30019);
                content_viewPager.setCurrentItem(2);
                break;
            default:
                break;
        }

    }

    private void restartButton() {
        //ImageView置为灰色
        iv_red_packet.setImageResource(R.drawable.redpacket0);
        iv_news.setImageResource(R.drawable.news0);
        iv_my.setImageResource(R.drawable.my0);

        //TextView置为灰色
        tv_red_packet.setTextColor(0xff666666);
        tv_news.setTextColor(0xff666666);
        tv_my.setTextColor(0xff666666);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
