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
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mContext = BaseApplication.getContext();
    }

    public abstract void navigation();
}
