package com.hbjy.lxy.library.rx;

import com.hbjy.lxy.library.log.DebugLog;

import rx.Subscriber;

/**
 * Created by 李小勇 on 2017/3/13.
 */

public class SimpleSubscriber<T> extends Subscriber<T>{
    @Override
    public void onCompleted() {
        DebugLog.log("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        DebugLog.log("onError");
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
        DebugLog.log("onNext");
    }
}
