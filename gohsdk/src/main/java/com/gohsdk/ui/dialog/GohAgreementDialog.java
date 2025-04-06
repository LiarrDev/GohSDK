package com.gohsdk.ui.dialog;

import android.app.AlertDialog;
import android.content.Context;

import com.gohsdk.settings.GlobalSettings;

public class GohAgreementDialog extends AlertDialog {

    public GohAgreementDialog(Context context) {
        super(context);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        GlobalSettings.setFirstLaunch(false);
    }
}
