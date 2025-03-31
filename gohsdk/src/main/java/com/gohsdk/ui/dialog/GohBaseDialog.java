package com.gohsdk.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gohsdk.utils.ResourceUtil;

public abstract class GohBaseDialog extends AlertDialog {

    public GohBaseDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = View.inflate(getContext(), ResourceUtil.getLayoutId(getLayoutName()), null);
        setContentView(rootView);
        initViews(rootView);
    }

    protected abstract void initViews(View rootView);

    protected abstract String getLayoutName();

    @Override
    public void show() {
        super.show();
        // AlertDialog EditText 不弹键盘，添加这两行
        Window window = getWindow();
        if (window != null) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        // 默认不允许关闭
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
