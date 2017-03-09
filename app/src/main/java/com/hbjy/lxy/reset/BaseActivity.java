package com.hbjy.lxy.reset;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;

import butterknife.OnClick;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public abstract class BaseActivity extends Activity {
    protected Context mContext;
    private BaseApplication application;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mContext = application.getContext();
    }

    public abstract void navigation();
}
