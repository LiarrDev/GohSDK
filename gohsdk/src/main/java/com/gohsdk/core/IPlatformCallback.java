package com.gohsdk.core;

import android.os.Bundle;

public interface IPlatformCallback {

    void onInit(int code, Bundle bundle);

    void onLogin(int code, Bundle bundle);

    void onPay(int code, Bundle bundle);

    void onLogout(int code, Bundle bundle);
}
