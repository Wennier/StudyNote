package com.example.wennier_r.projectitem.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.wennier_r.projectitem.domain.User;

/**
 * Created by Wennier_R on 2017/6/13.
 */

public class UserService {
    private UserbaseHelper userHelper;
    private Context mcontext;

    public UserService(Context context) {
        mcontext = context;
        userHelper = new UserbaseHelper(context);
    }

    public boolean login(String phonenum, String password) {
        SQLiteDatabase sdb = userHelper.getReadableDatabase();
        String sql = "select * from user where phonenum=? and password=?";
        Cursor cursor = sdb.rawQuery(sql, new String[]{""+phonenum+"", ""+password+""});
        if (cursor.moveToFirst() == true) {
            cursor.close();
            return true;
        }
        return false;
    }

    public boolean register(User user){
        SQLiteDatabase sdb = userHelper.getReadableDatabase();
        String sql = "insert into user(phonenum,password) values(?,?)";
        Object obj[] = {""+user.getPhonenum()+"",""+user.getPassword()+""};
        try{
            sdb.execSQL(sql,obj);
            return true;
        }catch (SQLiteConstraintException e)
        {
            Toast.makeText(mcontext,"该账号已经注册",Toast.LENGTH_SHORT).show();
            return false;
        }


    }

}
