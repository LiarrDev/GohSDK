package com.gohsdk.core;

import android.app.Activity;
import android.content.Intent;

import com.gohsdk.entities.GohPayEntity;
import com.gohsdk.entities.GohRole;

public interface IGame {

    void login(Activity activity);

    void logout(Activity activity);

    void pay(Activity activity, GohPayEntity pay);

    void event(String event, GohRole role);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onNewIntent(Intent intent);

    void onWindowFocusChanged(boolean hasFocus);

    void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults);
}
