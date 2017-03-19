package com.hbjy.lxy.reset.views.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hbjy.lxy.model.bean.CityInfo;
import com.hbjy.lxy.presenter.city.CityContract;
import com.hbjy.lxy.presenter.city.CityPresenter;
import com.hbjy.lxy.reset.R;
import com.hbjy.lxy.reset.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by 李小勇 on 2017/3/16.
 */
@Route(path = "/lxy/weather")
public class WeatherActivity extends BaseActivity implements CityContract.View{
    @InjectView(R.id.wea_et_city)
    EditText etCity;
    @InjectView(R.id.wea_bt_ok)
    Button btOk;
    @InjectView(R.id.wea_tv_city)
    TextView tvCity;
    @InjectView(R.id.wea_tv_temp)
    TextView tvTemp;
    @InjectView(R.id.wea_tv_weather)
    TextView tvWeather;
    @InjectView(R.id.wea_tv_time)
    TextView tvTime;

    private CityPresenter presenter;

    @Override
    public void navigation() {
        ARouter.getInstance().build("/lxy/weather").navigation();
    }

    @Override
    public void setContentView(Bundle savedInstanceState) {
        setContentView(R.layout.aty_weather);
        ButterKnife.inject(this);
    }

    @Override
    public void init() {

    }

    @Override
    protected void initPresenter() {
        presenter = new CityPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void destroyPresenter() {
        presenter.detachView();
    }

    @OnClick(R.id.wea_bt_ok)
    public void onClick() {
        String cityid = "北京";
        presenter.getCityInfo(cityid);
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void showNormal() {

    }

    @Override
    public void getSuccess() {
        showToast("获取成功");
    }

    @Override
    public void getFailed(String msg) {

    }

    @Override
    public void refreshData(CityInfo info) {
        Log.i("TAG", info.toString());
    }

}
