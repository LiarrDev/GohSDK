package com.gohsdk.core;

import android.app.Activity;
import android.os.Bundle;

import com.gohsdk.entities.GohGameConfig;
import com.gohsdk.net.GohRepository;
import com.gohsdk.settings.GlobalSettings;
import com.gohsdk.ui.dialog.GohAgreementDialog;
import com.gohsdk.utils.LogUtil;
import com.gohsdk.utils.ResourceUtil;
import com.google.gson.Gson;

public abstract class GohSDKCore {

    protected Activity activity;
    protected IPlatformCallback callback;
    public GohGameConfig config;
    private final GohRepository repository = new GohRepository();
    private final Gson gson = new Gson();


    public synchronized void init(Activity activity, IPlatformCallback callback) {
        LogUtil.v("init");
        this.activity = activity;
        this.callback = callback;

        boolean firstLaunch = GlobalSettings.isFirstLaunch();
        if (firstLaunch) {
            GohAgreementDialog dialog = new GohAgreementDialog(activity);
            dialog.show();
        } else {

        }
        initConfig();

        if (config != null) {
            this.callback.onInit(GohConstants.Code.SUCCESS, new Bundle());  // TODO: 所有配置加载成功后
        }
    }


    private void requestPermissions() {
        // TODO
        GlobalSettings.setFirstLaunch(false);
    }

    private void initConfig() {
        try {
            config = gson.fromJson(ResourceUtil.readAssets2String(GohConstants.GOH_GAME_CONFIG_FILE), GohGameConfig.class);
            LogUtil.e("config: " + config);
            repository.init(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() {

    }

    public void logout() {

    }

    public void pay() {

    }
}
