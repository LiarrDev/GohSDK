package com.gohsdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gohsdk.core.GohSDK;
import com.gohsdk.core.IPlatformCallback;
import com.gohsdk.ui.GohUserCenterDialog;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_init).setOnClickListener(this);
        findViewById(R.id.btn_user_center).setOnClickListener(this);
        findViewById(R.id.btn_float_ball).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_init) {
            GohSDK.get().init(this, new IPlatformCallback() {
                @Override
                public void onInit(int code, Bundle bundle) {

                }

                @Override
                public void onLogin(int code, Bundle bundle) {

                }

                @Override
                public void onPay(int code, Bundle bundle) {

                }

                @Override
                public void onLogout(int code, Bundle bundle) {

                }
            });
        } else if (view.getId() == R.id.btn_user_center) {
            GohUserCenterDialog dialog = new GohUserCenterDialog(this);
            dialog.show();
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.INVISIBLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}