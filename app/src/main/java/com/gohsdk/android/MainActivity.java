package com.gohsdk.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gohsdk.ui.GohUserCenterDialog;
import com.gohsdk.ui.view.FloatingView;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnUserCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUserCenter = findViewById(R.id.btn_user_center);
        btnUserCenter.setOnClickListener(this);
        findViewById(R.id.btn_float_ball).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_user_center) {
            GohUserCenterDialog dialog = new GohUserCenterDialog(this);
            dialog.show();
        } else if (view.getId() == R.id.btn_float_ball) {
            new FloatingView(this, R.mipmap.ic_launcher).show();
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