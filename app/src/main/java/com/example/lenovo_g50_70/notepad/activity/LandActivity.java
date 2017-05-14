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

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class LandActivity extends AppCompatActivity {
    private Button regUser;
    private Button landUser;
    private EditText edtUserName;
    private EditText edtUserPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land);
        initView();
    }

    private void initView() {
        edtUserName = (EditText) findViewById(R.id.edtUserName);
        edtUserPass = (EditText) findViewById(R.id.edtUserPass);
        landUser = (Button) findViewById(R.id.btnLand);
        landUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =edtUserName.getText().toString();
                String pass =edtUserPass.getText().toString();
                BmobUser.loginByAccount(name,pass, new LogInListener<UserInfo>() {

                    @Override
                    public void done(UserInfo user, BmobException e) {
                        if(user!=null){
                            Toast.makeText(getApplicationContext(),"登陆成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"登陆失败",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        regUser= (Button) findViewById(R.id.regUser);
        regUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });

    }
}
