package com.example.wennier_r.projectitem.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wennier_r.projectitem.my_activity.MainActivity;
import com.example.wennier_r.projectitem.R;
import com.example.wennier_r.projectitem.database.UserService;
import com.example.wennier_r.projectitem.my_activity.RegisterActivity;

/**
 * Created by Wennier_R on 2017/6/10.
 */

public class MyFragment extends Fragment implements View.OnClickListener {

    private Button signin ;
    private Button login ;
    private EditText phonenum ;
    private EditText pass ;

    public static int index = 0;

    public static MyFragment getInstance(){
        return new MyFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_my,container,false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        signin = (Button) mView.findViewById(R.id.signin);
        login = (Button) mView.findViewById(R.id.login);
        phonenum = (EditText) mView.findViewById(R.id.phonenum);
        pass = (EditText) mView.findViewById(R.id.password);

        signin.setOnClickListener(this);
        login.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signin:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                break;
            case R.id.login:
                String username = phonenum.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if(TextUtils.isEmpty(username))
                {
                    phonenum.setError("用户名不能为空");
                }
                if (TextUtils.isEmpty(password)) {

                pass.setError("密码不能为空");
                }else {

                UserService us = new UserService(getActivity());
                boolean c =  us.login(username,password);
                if(c)
                {
                    index = 1;
                    startActivity(new Intent(getActivity(), MainActivity.class));
                }else {
                    Toast.makeText(getActivity(),"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }



        }
    }
}
