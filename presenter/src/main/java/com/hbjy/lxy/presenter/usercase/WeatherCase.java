package com.hbjy.lxy.presenter.usercase;

import com.hbjy.lxy.library.rx.transformers.SchedulersCompat;
import com.hbjy.lxy.model.bean.WeatherInfo;
import com.hbjy.lxy.model.dagger.ApiComponentHolder;
import com.hbjy.lxy.model.request.WeatherRequest;
import com.hbjy.lxy.presenter.UserCase;

import rx.Observable;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public class WeatherCase extends UserCase<WeatherInfo,String> {
    @Override
    protected Observable<WeatherInfo> interactor(String params) {
        return ApiComponentHolder.apiComponent
                .apiService()
                .getWeatherInfo(params)
                .take(1)
                .compose(SchedulersCompat.<WeatherInfo>applyNewSchedulers());
    }
}
