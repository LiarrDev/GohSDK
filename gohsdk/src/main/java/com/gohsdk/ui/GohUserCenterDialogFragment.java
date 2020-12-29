package com.gohsdk.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.gohsdk.utils.DeviceUtil;
import com.gohsdk.utils.ResourceUtil;

public class GohUserCenterDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(ResourceUtil.getLayoutId(getActivity(), "goh_user_center_dialog"), null);
        ImageButton ibBack = rootView.findViewById(ResourceUtil.getViewId(getActivity(), "btn_back"));
        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams params = window.getAttributes();
            if (DeviceUtil.isPortrait()) {      // 竖屏
                window.setGravity(Gravity.BOTTOM);
                params.height = DeviceUtil.getScreenHeight() / 3 * 2;
                params.width = WindowManager.LayoutParams.MATCH_PARENT;
            } else {        // 横屏
                window.setGravity(Gravity.START);
                params.width = DeviceUtil.getScreenWidth() / 2;
                params.height = WindowManager.LayoutParams.MATCH_PARENT;
            }
        }
    }

    @Override
    public void onStart() {
        getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        super.onStart();
        getDialog().getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
        );
        getDialog().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
    }
}
