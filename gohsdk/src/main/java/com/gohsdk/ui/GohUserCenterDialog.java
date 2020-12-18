package com.gohsdk.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.gohsdk.utils.DeviceUtil;
import com.gohsdk.utils.ResourceUtil;

public class GohUserCenterDialog extends AlertDialog {

    public GohUserCenterDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(getContext(), ResourceUtil.getLayoutId(getContext(), "goh_user_center_dialog"), null);
        setContentView(rootView);

        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams params = window.getAttributes();
            DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
            if (DeviceUtil.isPortrait(getContext())) {      // 竖屏
                window.setGravity(Gravity.BOTTOM);
                params.height = dm.heightPixels / 2;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
            } else {        // 横屏
                window.setGravity(Gravity.START);
                params.width = dm.widthPixels / 2;
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
            }
        }

        ImageButton ibBack = rootView.findViewById(ResourceUtil.getViewId(getContext(), "btn_back"));
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();
        int flag = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        getWindow().getDecorView().setSystemUiVisibility(flag);

    }
}
