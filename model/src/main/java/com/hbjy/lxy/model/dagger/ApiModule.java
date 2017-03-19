package com.hbjy.lxy.model.dagger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hbjy.lxy.library.log.DebugLog;
import com.hbjy.lxy.model.ApiService;

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李小勇 on 2017/3/16.
 */
@Module
public class ApiModule {
    private final static int HTTP_TIME_OUT = 30;

    @Named("UseForBasic")
    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(){
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(request);
            }
        };

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                DebugLog.log(message);
            }
        });

        return new OkHttpClient.Builder()
                .connectTimeout(HTTP_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(HTTP_TIME_OUT,TimeUnit.SECONDS)
                .writeTimeout(HTTP_TIME_OUT,TimeUnit.SECONDS)
                .addInterceptor(headerInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @Singleton
    @Provides
    public ApiService provideApiService(@Named("UseForBasic") OkHttpClient client){
        Gson gson = new GsonBuilder().create();
        //String url = String.format(Locale.getDefault(),"http://%s:%s/",ApiService.IP_SERVER,ApiService.IP_PORT);
        String url = "http://gc.ditu.aliyun.com/";
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return builder.create(ApiService.class);
    }
}
