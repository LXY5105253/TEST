package com.hbjy.lxy.reset.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hbjy.lxy.model.dagger.ApiComponent;
import com.hbjy.lxy.model.dagger.ApiComponentHolder;
import com.hbjy.lxy.model.dagger.ApiModule;
import com.hbjy.lxy.model.dagger.DaggerApiComponent;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class BaseApplication extends Application {
    private static Context mContext;

    private boolean isDebug = false;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
        initARouter();
        initDagger();
    }

    private void init(){
        mContext = getApplicationContext();
        isDebug = isApkDebugable();
    }
    public static Context getContext(){
        return mContext;
    }

    public boolean isApkDebugable() {
        try {
            ApplicationInfo info= mContext.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {

        }
        return false;
    }
    private void initARouter(){
        if (isDebug){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    private void initDagger(){
        ApiComponent apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
        ApiComponentHolder.apiComponent = apiComponent;
    }

}
