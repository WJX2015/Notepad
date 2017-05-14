package com.example.lenovo_g50_70.notepad.model;

import cn.bmob.v3.BmobUser;

/**
 * Created by lenovo-G50-70 on 2017/5/13.
 */

public class UserInfo extends BmobUser {
    private String userName;

    public UserInfo(){

    }

    public UserInfo(String userName,String passWord,String tableName){
        this.userName=userName;
        this.passWord=passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String passWord;
}
