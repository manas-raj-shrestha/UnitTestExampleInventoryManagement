package com.leapfrog.inventorymanagementsystem.api;

/**
 * Created by laaptu on 4/3/16.
 */


public interface DataCallback<T> {
    void onResponse(T response);
    void onFailure(String error);
}
