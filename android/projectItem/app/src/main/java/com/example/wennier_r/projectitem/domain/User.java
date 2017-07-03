package com.example.wennier_r.projectitem.domain;

import java.io.Serializable;

/**
 * Created by Wennier_R on 2017/6/12.
 */

public class User implements Serializable {
   private String phonenum;
    private String password;
    private int isLogin = 0;

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public User(){
        super();
    }
    public User(String phonenum, String password) {
        this.phonenum = phonenum;
        this.password = password;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
