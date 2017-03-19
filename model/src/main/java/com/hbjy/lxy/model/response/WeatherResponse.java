package com.hbjy.lxy.model.response;

import com.google.gson.annotations.SerializedName;
import com.hbjy.lxy.model.bean.WeatherBean;

/**
 * Created by 李小勇 on 2017/3/17.
 */

public class WeatherResponse {

    @SerializedName("weatherinfo")
    public WeatherBean weatherBean;
}
