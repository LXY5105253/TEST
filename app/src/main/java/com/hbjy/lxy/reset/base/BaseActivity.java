package com.hbjy.lxy.reset.base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.hbjy.lxy.rxview.helper.SupportActivity;

/**
 * Created by Administrator on 2017/3/9 0009.
 */

public abstract class BaseActivity extends SupportActivity{

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

    protected void showToast(CharSequence text){
        Toast.makeText(mContext,text,Toast.LENGTH_SHORT).show();
    }

    protected void showToast(int resid){
        Toast.makeText(mContext,resid,Toast.LENGTH_SHORT).show();
    }
}
