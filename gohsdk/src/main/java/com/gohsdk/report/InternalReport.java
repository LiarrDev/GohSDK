package com.gohsdk.report;

import android.app.Activity;
import android.content.Context;

import com.gohsdk.utils.LogUtil;

import java.util.HashMap;

class InternalReport implements IReport {

    @Override
    public void onApplication(Context context) {
        LogUtil.v("onApplication");
    }

    @Override
    public void onCreate(Activity activity) {
        LogUtil.v("onCreate");
    }

    @Override
    public void onStart(Activity activity) {
        LogUtil.v("onStart");
    }

    @Override
    public void onResume(Activity activity) {
        LogUtil.v("onResume");
    }

    @Override
    public void onPause(Activity activity) {
        LogUtil.v("onPause");
    }

    @Override
    public void onStop(Activity activity) {
        LogUtil.v("onStop");
    }

    @Override
    public void onDestroy(Activity activity) {
        LogUtil.v("onDestroy");
    }

    @Override
    public void onRestart(Activity activity) {
        LogUtil.v("onRestart");
    }

    @Override
    public void onRegisterEvent(Context context, HashMap<String, String> map) {
        LogUtil.v("onRegisterEvent: " + map.toString());
    }

    @Override
    public void onPayEvent(Context context, HashMap<String, String> map) {
        LogUtil.v("onPayEvent: " + map.toString());
    }

    @Override
    public void onCustomEvent(Context context, HashMap<String, String> map) {
        LogUtil.v("onCustomEvent: " + map.toString());
    }
}