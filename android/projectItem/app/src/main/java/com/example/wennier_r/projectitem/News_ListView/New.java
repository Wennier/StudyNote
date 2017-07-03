package com.example.wennier_r.projectitem.News_ListView;

/**
 * Created by Wennier_R on 2017/6/12.
 */

public class New {
    private String mNewsTitle = null;
    private String mNewsBody = null;
    private int mNewsPic ;

    public New(String mNewsTitle , String mNewsBody , int mNewsPic){
        this.mNewsBody = mNewsBody;
        this.mNewsTitle = mNewsTitle;
        this.mNewsPic = mNewsPic;
    }


    public void setmNewsTitle (String mNewsTitle){
        this.mNewsTitle  = mNewsTitle;
    }
    public String getmNewsTitle(){
        return this.mNewsTitle;
    }

    public void setmNewsBody(String mNewsBody){
        this.mNewsBody = mNewsBody;
    }
    public String getmNewsBody(){
        return this.mNewsBody;
    }

    public void setmNewPic(int mNewsPic){
        this.mNewsPic = mNewsPic;
    }
    public int getmNewsPic(){
        return this.mNewsPic;
    }
}
