package com.example.wennier_r.projectitem.fragment;

import java.io.File;
import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by Wennier_R on 2017/6/12.
 */

public class JavaBean extends BmobObject implements Serializable{
    private String title;
    private String content;
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "JavaBean{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", image=" + image +
                '}';
    }
}
