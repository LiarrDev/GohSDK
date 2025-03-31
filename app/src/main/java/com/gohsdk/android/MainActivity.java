package com.gohsdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.gohsdk.core.GohSDK;
import com.gohsdk.core.IPlatformCallback;
import com.gohsdk.ui.GohUserCenterDialog;
import com.gohsdk.ui.dialog.GohLoginDialog;
import com.gohsdk.ui.view.GohFloatingBall;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_init).setOnClickListener(this);
        findViewById(R.id.btn_user_center).setOnClickListener(this);
        findViewById(R.id.btn_float_ball).setOnClickListener(this);
        findViewById(R.id.btn_login).setOnClickListener(this);
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
        } else if (view.getId() == R.id.btn_login) {
            GohLoginDialog dialog = new GohLoginDialog(this);
            dialog.show();
        } else if (view.getId() == R.id.btn_user_center) {
            GohUserCenterDialog dialog = new GohUserCenterDialog(this);
            dialog.show();
        } else if (view.getId() == R.id.btn_float_ball) {
            GohFloatingBall ball = new GohFloatingBall();
            ball.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    GohUserCenterDialog dialog = new GohUserCenterDialog(v.getContext());
                    dialog.show();
                }
            });
            ball.show();
        }
    }
}