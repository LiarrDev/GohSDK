package com.gohsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.gohsdk.GohBaseApplication;

public class DeviceUtil {

    /**
     * 判断是否为竖屏
     */
    public static boolean isPortrait() {
        return GohBaseApplication.getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }

    /**
     * 屏幕宽度
     */
    public static int getScreenWidth() {
        return GohBaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 屏幕高度
     */
    public static int getScreenHeight() {
        return GohBaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 屏幕尺寸
     */
    public static String getScreenSize() {
        return getScreenHeight() + "×" + getScreenWidth();
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
    public static String getNetworkOperatorName() {
        TelephonyManager tm = (TelephonyManager) GohBaseApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm == null) {
            return "";
        }
        String networkOperatorName = tm.getNetworkOperatorName();
        return TextUtils.isEmpty(networkOperatorName) ? "" : networkOperatorName;
    }

    /**
     * ANDROID_ID
     */
    public static String getAndroidId() {
        return Settings.System.getString(GohBaseApplication.getContext().getContentResolver(), Settings.Secure.ANDROID_ID);
    }
}
