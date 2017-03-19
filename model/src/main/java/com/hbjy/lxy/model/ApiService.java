package com.hbjy.lxy.model;

import com.hbjy.lxy.model.bean.CityInfo;
import com.hbjy.lxy.model.bean.WeatherInfo;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryName;
import rx.Observable;

/**
 * Created by 李小勇 on 2017/3/16.
 */

public interface ApiService {
    String IP_SERVER = "60.213.21.211";
    String IP_PORT = "80";
    long CACHE_TIME = 2 * 60 * 60 * 1000;

    @GET("/data/cityinfo/{cityid}")
    Observable<WeatherInfo> getWeatherInfo(@Path("cityid") String cityid);

    @GET("geocoding")
    Observable<CityInfo> getCityInfo(@Query("a") String cityName);
}
