package com.leapfrog.inventorymanagementsystem.api;

import com.leapfrog.inventorymanagementsystem.data.Customer;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 */
public class EntityInterceptor {
    static volatile EntityInterceptor entityInterceptor;

    private EntityInterceptor() {

    }

    public static EntityInterceptor getInstance() {
        if (entityInterceptor == null) {
            synchronized (EntityInterceptor.class) {
                if (entityInterceptor == null)
                    entityInterceptor = new EntityInterceptor();
            }
        }
        return entityInterceptor;
    }


    public void createCustomer(final DataCallback<Customer> dataCallback, String... params) {
        //params 0 = token
        // params 1 = name
        //params 2 = email
        String authorization = ApiUtils.generateBasicAuthHeader(EndPoints.STRIPE_SECRET_KEY, "");
        RetrofitManager.getApiService().createStripeCustomer(authorization, params[0], params[1], params[2]).enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response != null && response.body() != null) {
                    dataCallback.onResponse(response.body());
                    return;
                }
                dataCallback.onFailure("Error");
            }

            @Override
            public void onFailure(Call<Customer> call, Throwable t) {
                dataCallback.onFailure("Error");

            }
        });
    }

    public void createCharge(final DataCallback<ResponseBody> dataCallback, String... params) {
        //params 0 = amount
        //params 1= currency
        //params 2 = cusomterId
        String authorization = ApiUtils.generateBasicAuthHeader(EndPoints.STRIPE_SECRET_KEY, "");
        RetrofitManager.getApiService().createCharge(authorization, params[0], params[1], params[2]).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null && response.body() != null)
                    try {
                        Timber.d("Charge Create response =%s", response.body().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                else
                    Timber.d("Response body is null");
                dataCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                dataCallback.onFailure("Error");
            }
        });
    }


}
