package com.gohsdk.utils;

import android.content.Context;
import android.content.res.Configuration;

public class DeviceUtil {

    /**
     * 判断是否为竖屏
     */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
    }
}
