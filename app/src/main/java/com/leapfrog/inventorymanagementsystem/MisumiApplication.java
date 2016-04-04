package com.leapfrog.inventorymanagementsystem;

import android.app.Application;
import android.content.Context;

import com.orhanobut.hawk.Hawk;
import com.orhanobut.hawk.HawkBuilder;
import com.orhanobut.hawk.LogLevel;

/**
 * Application class
 */
public class MisumiApplication extends Application {

    static MisumiApplication misumiApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        misumiApplication = this;
        initHawk();
    }

    public static Context getContext() {
        return misumiApplication;
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
