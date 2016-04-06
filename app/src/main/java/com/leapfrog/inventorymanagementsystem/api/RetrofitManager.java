package com.leapfrog.inventorymanagementsystem.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by laaptu on 4/3/16.
 */
public class RetrofitManager {
    static volatile Retrofit retrofit;

    private static ApiService apiService;

    private RetrofitManager() {

    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (RetrofitManager.class) {
                if (retrofit == null) {
                    OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();
                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
                    okhttpClientBuilder.addInterceptor(loggingInterceptor);
                    retrofit = new Retrofit.Builder()
                            .baseUrl(EndPoints.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(okhttpClientBuilder.build())
                            .build();
                }
            }
        }

        return retrofit;
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (RetrofitManager.class) {
                if (apiService == null)
                    apiService = getRetrofit().create(ApiService.class);
            }
        }
        return apiService;
    }
}
