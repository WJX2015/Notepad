package com.example.lenovo_g50_70.notepad.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo_g50_70.notepad.R;
import com.example.lenovo_g50_70.notepad.model.UserInfo;

import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;

public class RegisterActivity extends AppCompatActivity {
    private EditText regUserName;
    private EditText regUserPass;
    private Button btnRegister;
    private Button btngetCode;
    private String username;
    private String userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initVIew();
    }

    private void initVIew() {
        regUserName = (EditText) findViewById(R.id.regUserName);
        regUserPass = (EditText) findViewById(R.id.regUserPass);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btngetCode = (Button) findViewById(R.id.getCode);
        btngetCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username =regUserName.getText().toString().trim();
                BmobSMS.requestSMSCode(username,"ccc", new QueryListener<Integer>() {

                    @Override
                    public void done(Integer smsId,BmobException ex) {
                        if(ex==null){
                            Toast.makeText(getApplicationContext(),username,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = regUserName.getText().toString().trim();
                userpass = regUserPass.getText().toString().trim();
                BmobUser.loginBySMSCode(username,userpass, new LogInListener<UserInfo>() {

                    @Override
                    public void done(UserInfo user, BmobException e) {
                        if(user!=null){
                            Toast.makeText(getApplicationContext(),"用户登陆成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"用户登陆失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
