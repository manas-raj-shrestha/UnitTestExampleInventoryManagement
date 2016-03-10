package com.leapfrog.inventorymanagementsystem;

import android.app.Application;
import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

/**
 * Created by Manas on 3/10/2016.
 */
public class ShopflixApplication extends Application {

    static ShopflixApplication shopflixApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        shopflixApplication = this;
        initHawk();
    }

    public static Context getContext() {
        return shopflixApplication;
    }

    /**
     * Initialize hawk for shared preference
     */
    private void initHawk() {
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSharedPrefStorage(this))
                .setLogLevel(LogLevel.FULL)
                .build();
    }
}
