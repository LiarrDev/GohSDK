package com.gohsdk.report;

import android.app.Activity;
import android.content.Context;

import java.util.HashMap;

public interface IReport {

    void onApplication(Context context);

    void onCreate(Activity activity);

    void onStart(Activity activity);

    void onResume(Activity activity);

    void onPause(Activity activity);

    void onStop(Activity activity);

    void onDestroy(Activity activity);

    void onRestart(Activity activity);

    void onRegisterEvent(Context context, HashMap<String, String> map);

    void onPayEvent(Context context, HashMap<String, String> map);

    void onCustomEvent(Context context, HashMap<String, String> map);
}
