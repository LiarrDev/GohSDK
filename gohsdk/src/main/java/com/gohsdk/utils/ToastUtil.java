package com.gohsdk.utils;

import android.widget.Toast;

import com.gohsdk.GohBaseApplication;

public class ToastUtil {
    public static void show(String msg) {
        Toast.makeText(GohBaseApplication.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
