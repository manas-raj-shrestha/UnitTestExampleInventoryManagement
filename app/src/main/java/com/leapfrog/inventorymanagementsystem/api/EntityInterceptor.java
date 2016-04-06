package com.leapfrog.inventorymanagementsystem.api;

import com.leapfrog.inventorymanagementsystem.data.Customer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                if(response !=null && response.body() !=null){
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


}
