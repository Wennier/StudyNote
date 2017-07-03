package com.example.wennier_r.projectitem.my_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wennier_r.projectitem.R;
import com.example.wennier_r.projectitem.database.UserService;
import com.example.wennier_r.projectitem.domain.User;

/**
 * Created by Wennier_R on 2017/6/13.
 */

public class RegisterActivity extends Activity {

    EditText phonenum;
    EditText password;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        findViews();
        signin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String phone = phonenum.getText().toString().trim();
                String pass = password.getText().toString().trim();
                Log.i("TAG",phone+"--"+pass+"--");
                UserService userService = new UserService(RegisterActivity.this);
                User user = new User();
                user.setPhonenum(phone);
                user.setPassword(pass);
               boolean c =  userService.register(user);
                if(c)
                {
                    Toast.makeText(RegisterActivity.this,"添加数据成功",Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }
    private void findViews(){
        phonenum =(EditText) findViewById(R.id.signinphonenum);
        password = (EditText) findViewById(R.id.signinpassword);
        signin = (Button) findViewById(R.id.signin_login);

    }
}
