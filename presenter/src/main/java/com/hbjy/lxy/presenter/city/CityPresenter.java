package com.hbjy.lxy.presenter.city;

import com.hbjy.lxy.library.rx.SimpleSubscriber;
import com.hbjy.lxy.model.bean.CityInfo;
import com.hbjy.lxy.presenter.usercase.CityCase;

import java.lang.ref.WeakReference;

/**
 * Created by 李小勇 on 2017/3/19.
 */

public class CityPresenter implements CityContract.Presenter {
    private WeakReference<CityContract.View> wrView;
    private CityCase cityCase;
    @Override
    public void attachView(CityContract.View view) {
        wrView = new WeakReference<>(view);
        cityCase = new CityCase();
    }

    @Override
    public void detachView() {
        //清空view
        wrView.clear();
        //注销订阅
        cityCase.unSubscribe();
    }

    @Override
    public void getCityInfo(String params) {
        cityCase.params(params)
                .viewFilter(wrView)
                .subscribe(new SimpleSubscriber<CityInfo>() {
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        CityContract.View view = wrView.get();
                        if (view != null) {
                            view.getFailed(null);
                        }
                    }

                    @Override
                    public void onNext(CityInfo info) {
                        super.onNext(info);
                        CityContract.View view = wrView.get();
                        view.getSuccess();
                        view.refreshData(info);
                    }
                });
    }
}
