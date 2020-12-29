package com.gohsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class DeviceUtil {

    /**
     * 判断是否为竖屏
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
    
    /**
     * 屏幕宽度
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 屏幕高度
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 屏幕尺寸
     */
    public static String getScreenSize(Context context) {
        return getScreenHeight(context) + "×" + getScreenWidth(context);
    }

    /**
     * 设备型号
     */
    public static String getPhoneModel() {
        return android.os.Build.MANUFACTURER + " " + android.os.Build.MODEL;
    }

    /**
     * 系统版本
     */
    public static String getOsVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 网络运营商
     */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        String networkOperatorName = tm.getNetworkOperatorName();
        return TextUtils.isEmpty(networkOperatorName) ? "" : networkOperatorName;
    }

    /**
     * ANDROID_ID
     */
    public static String getAndroidId(Context context) {
        return Settings.System.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
