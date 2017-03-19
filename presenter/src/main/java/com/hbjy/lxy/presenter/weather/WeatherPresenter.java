package com.hbjy.lxy.presenter.weather;

import com.hbjy.lxy.library.rx.SimpleSubscriber;
import com.hbjy.lxy.library.util.Preconditions;
import com.hbjy.lxy.model.bean.WeatherInfo;
import com.hbjy.lxy.presenter.usercase.WeatherCase;

import java.lang.ref.WeakReference;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeakReference<WeatherContract.View> wrView;
    private WeatherCase weatherCase;
    @Override
    public void attachView(WeatherContract.View view) {
        wrView = new WeakReference<>(view);
        weatherCase = new WeatherCase();
    }

    @Override
    public void detachView() {
        wrView.clear();
        weatherCase.unSubscribe();
    }

    @Override
    public void getWeatherInfo(String cityid) {
        Preconditions.checkNotNull(weatherCase,"Must call attachView method first!");
        weatherCase.params(cityid)
                .viewFilter(wrView)
                .subscribe(new SimpleSubscriber<WeatherInfo>(){
                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        WeatherContract.View view = wrView.get();
                        if (view != null) {
                            view.getFailed(null);
                        }
                    }

                    @Override
                    public void onNext(WeatherInfo weatherInfo) {
                        super.onNext(weatherInfo);
                        WeatherContract.View view = wrView.get();
                        view.getSuccess();
                        view.refreshData(weatherInfo);
                    }
                });

    }
}
