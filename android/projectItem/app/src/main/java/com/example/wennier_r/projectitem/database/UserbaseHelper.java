package com.example.wennier_r.projectitem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.wennier_r.projectitem.domain.User;

/**
 * Created by Wennier_R on 2017/6/12.
 */

public class UserbaseHelper extends SQLiteOpenHelper{
    static String name = "user.db";
    static int dbVersion = 1;

    public UserbaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user(phonenum varchar(50) primary key ,password varchar(20),isLogin int)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
