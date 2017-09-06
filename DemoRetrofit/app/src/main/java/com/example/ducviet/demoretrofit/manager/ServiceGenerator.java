package com.example.ducviet.demoretrofit.manager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ducviet on 31/08/2017.
 */

public class ServiceGenerator {
    private static final String URL_GET_POST = "https://api.github.com";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(URL_GET_POST)
            .addConverterFactory(GsonConverterFactory.create());
    private static HttpLoggingInterceptor httpLoggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okHttpClientBuilder =
            new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
    private static OkHttpClient okHttpClient = okHttpClientBuilder.build();
    public static <T>  T createService (Class<T> serviceClass){
        if (retrofit == null){
            retrofit = builder.client(okHttpClient).build();
        }
        return retrofit.create(serviceClass);
    }
}
