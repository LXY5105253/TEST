package com.hbjy.lxy.presenter.city;

import com.hbjy.lxy.model.bean.CityInfo;
import com.hbjy.lxy.presenter.IBasePresenter;
import com.hbjy.lxy.presenter.IBaseView;

/**
 * Created by 李小勇 on 2017/3/19.
 */

public interface CityContract {
    /**
     * 网络数据请求后
     */
    interface View extends IBaseView{
        void getSuccess();
        void getFailed(String msg);
        void refreshData(CityInfo info);
    }

    /**
     * 网络数据请求前
     * 用于网络数据请求
     */
    interface Presenter extends IBasePresenter<View>{
        void getCityInfo(String params);
    }
}
