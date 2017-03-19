package com.hbjy.lxy.presenter.weather;

import com.hbjy.lxy.model.bean.WeatherInfo;
import com.hbjy.lxy.presenter.IBasePresenter;
import com.hbjy.lxy.presenter.IBaseView;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public interface WeatherContract {
    interface View extends IBaseView{
        void getSuccess();
        void getFailed(String msg);
        void refreshData(WeatherInfo weatherInfo);
    }

    interface Presenter extends IBasePresenter<View>{
        void getWeatherInfo(String cityid);
    }
}
