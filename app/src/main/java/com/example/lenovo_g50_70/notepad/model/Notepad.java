package com.example.lenovo_g50_70.notepad.model;

import org.litepal.crud.DataSupport;

/**
 * Created by lenovo-G50-70 on 2017/5/12.
 */

public class Notepad extends DataSupport{
    private String node;

    public Notepad(){

    }

    public Notepad(String node, String date){
        this.node=node;
        this.date=date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    private String date;
}
