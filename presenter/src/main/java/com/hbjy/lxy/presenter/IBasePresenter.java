package com.hbjy.lxy.presenter;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public interface IBasePresenter<R> {
    /**
     * 添加view
     * @param view
     */
    void attachView(R view);

    /**
     * 销毁view
     */
    void detachView();
}
