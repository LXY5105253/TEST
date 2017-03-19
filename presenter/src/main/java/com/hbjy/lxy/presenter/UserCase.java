package com.hbjy.lxy.presenter;

import com.hbjy.lxy.library.log.DebugLog;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public abstract class UserCase<R,T> {
    private Subscription subscription = Subscriptions.empty();
    private T params;
    private WeakReference view;

    public UserCase<R,T> params(T params){
        this.params = params;
        return this;
    }

    public UserCase<R,T> viewFilter(final WeakReference view){
        this.view = view;
        return this;
    }

    public void subscribe(final Observer<R> subscriber) {
        subscription = this.interactor(params)
                .filter(new Func1<R, Boolean>() {
                    @Override
                    public Boolean call(R r) {
                        DebugLog.log("Filter!!");
                        if (view != null) {
                            DebugLog.log("view is null? %s", view.get() == null ? "true" : "false");
                            return view.get() != null && !subscription.isUnsubscribed();
                        } else {
                            return !subscription.isUnsubscribed();
                        }
                    }
                })
                .onBackpressureBuffer()
                .subscribe(subscriber);
    }

    public void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        if (view != null) {
            view.clear();
        }
    }

    protected abstract Observable<R> interactor(T params);
}
