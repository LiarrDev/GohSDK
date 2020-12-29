package com.gohsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * SDK 内部 Application，
 * 对 CP 和渠道应使用 GohApplication
 */
public class GohBaseApplication extends Application {

    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
