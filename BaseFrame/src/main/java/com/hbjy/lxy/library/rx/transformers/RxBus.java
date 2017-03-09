package com.hbjy.lxy.library.rx.transformers;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Administrator on 2017/3/8 0008.
 */

public class RxBus {
    private static RxBus instance;

    private Subject<Object,Object> rxStandarBus;

    public static RxBus getInstance(){
        if (instance == null) {
            synchronized (RxBus.class){
                if (instance == null){
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    public RxBus(){
        rxStandarBus = new SerializedSubject<>(PublishSubject.create());
    }

    /**
     * 判断是否有订阅者
     * @return
     */
    private boolean hasObservers(){
        return rxStandarBus.hasObservers();
    }

    public void postEvent(Object event){
        if (! hasObservers()){
            return;
        }
        rxStandarBus.onNext(event);
    }

    public <T>Observable<T> toObservable(Class<T> clazz){
        return rxStandarBus.asObservable().onBackpressureBuffer().ofType(clazz);
    }
}
