package com.hbjy.lxy.reset.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseApplication.getContext();
        setContentView(savedInstanceState);
        init();
    }

    public abstract void navigation();
    public abstract void setContentView(Bundle savedInstanceState);
    public abstract void init();
}
