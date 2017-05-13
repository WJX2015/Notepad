package com.example.lenovo_g50_70.notepad.presenter.impl;

import com.example.lenovo_g50_70.notepad.presenter.MainPresenter;
import com.example.lenovo_g50_70.notepad.view.MainView;

/**
 * Created by lenovo-G50-70 on 2017/5/13.
 */

public class MainPresenterImpl implements MainPresenter{
    private MainView mView;
    public MainPresenterImpl(MainView view){
        mView=view;
    }

    @Override
    public void onLoadData() {
        //获取数据的逻辑
        mView.onLoadDataSuccess();
    }
}
