package com.example.lenovo_g50_70.notepad.app;

import android.content.Context;

import org.litepal.LitePal;

import cn.bmob.v3.Bmob;

/**
 * Created by lenovo-G50-70 on 2017/5/11.
 */

public class MyApplication extends android.app.Application {
    private static Context context;

    @Override
    public void onCreate() {
        context =getApplicationContext();
        Bmob.initialize(this,"1a6eb85c8bacec0dbd2c07a6b05971e6");
        LitePal.initialize(context);
    }

    public static Context getContext(){
        return context;
    }
}
