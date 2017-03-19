package com.hbjy.lxy.presenter.usercase;

import com.hbjy.lxy.library.rx.transformers.SchedulersCompat;
import com.hbjy.lxy.model.bean.CityInfo;
import com.hbjy.lxy.model.dagger.ApiComponentHolder;
import com.hbjy.lxy.presenter.UserCase;

import rx.Observable;

/**
 * Created by 李小勇 on 2017/3/19.
 */

public class CityCase extends UserCase<CityInfo,String> {
    @Override
    protected Observable<CityInfo> interactor(String params) {

        return ApiComponentHolder.apiComponent
                .apiService()
                .getCityInfo(params)
                .take(1)
                .compose(SchedulersCompat.<CityInfo>applyNewSchedulers());
    }
}
