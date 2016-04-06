package com.leapfrog.inventorymanagementsystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leapfrog.inventorymanagementsystem.api.ApiUtils;
import com.leapfrog.inventorymanagementsystem.api.EndPoints;

import timber.log.Timber;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String encodedString = ApiUtils.generateBasicAuthHeader(EndPoints.STRIPE_SECRET_KEY, "");
        Timber.d("EncodedString =%s",encodedString);

    }
}
