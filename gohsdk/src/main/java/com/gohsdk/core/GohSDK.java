package com.gohsdk.core;

public class GohSDK extends GohSDKCore {

    private GohSDK() {
    }

    private static final GohSDK instance = new GohSDK();

    public static GohSDK get() {
        return instance;
    }
}
