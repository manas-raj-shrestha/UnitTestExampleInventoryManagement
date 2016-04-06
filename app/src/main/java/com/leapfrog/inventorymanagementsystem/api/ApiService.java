package com.leapfrog.inventorymanagementsystem.api;

import com.leapfrog.inventorymanagementsystem.data.Charge;
import com.leapfrog.inventorymanagementsystem.data.Customer;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by laaptu on 4/3/16.
 */
public interface ApiService {

    @GET("https://httpbin.org/get")
    Call<ResponseBody> getSomething();

    @FormUrlEncoded
    @POST("https://api.stripe.com/v1/customers")
    Call<Customer> createStripeCustomer(
            @Header("Authorization") String authorization,
            @Field("source") String token,
            @Field("description") String customerName,
            @Field("email") String email
    );

    @FormUrlEncoded
    @POST("https://api.stripe.com/v1/charges")
    Call<Charge> createCharge(
            @Header("Authorization") String authorization,
            @Field("amount") String amount,
            @Field("currency") String currency,
            @Field("customer") String customerId
    );

}
