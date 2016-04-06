package com.leapfrog.inventorymanagementsystem.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by laaptu on 4/3/16.
 */
public interface ApiService {

    @GET("https://httpbin.org/get")
    Call<ResponseBody> getSomething();
}
