package com.gohsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.gohsdk.GohBaseApplication;

public class SPUtil {

    private static final String SP_NAME = "goh_sdk_cache";

    public static void put(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public static String get(String key, String defValue) {
        return getSharedPreferences().getString(key, defValue);
    }

    public static void put(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public static int get(String key, int defValue) {
        return getSharedPreferences().getInt(key, defValue);
    }

    public static void put(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public static boolean get(String key, boolean defValue) {
        return getSharedPreferences().getBoolean(key, defValue);
    }

    private static SharedPreferences getSharedPreferences() {
        return GohBaseApplication.getContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }
}
