package com.hbjy.lxy.model.dagger;

import com.hbjy.lxy.model.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 李小勇 on 2017/3/16.
 */
@Component(modules = {ApiModule.class})
@Singleton
public interface ApiComponent {
    ApiService apiService();
}
