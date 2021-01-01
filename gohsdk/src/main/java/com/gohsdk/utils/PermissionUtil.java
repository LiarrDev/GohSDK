package com.gohsdk.utils;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;

import com.gohsdk.ui.GohPermissionFragment;

import java.util.List;

public class PermissionUtil {

    private static final String TAG = "GohPermissionFragment";

    public static void apply(Activity activity, String[] permissions, PermissionCallback callback) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        Fragment existedFragment = fragmentManager.findFragmentByTag(TAG);
        GohPermissionFragment fragment;
        if (existedFragment != null) {
            fragment = (GohPermissionFragment) existedFragment;
        } else {
            fragment = new GohPermissionFragment();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                fragmentManager.beginTransaction().add(fragment, TAG).commitNow();
            } else {
                // TODO: Need test here, but I'm too lazy...
                fragmentManager.beginTransaction().add(fragment, TAG).commit();
//                fragmentManager.executePendingTransactions();
            }
        }
        fragment.apply(permissions, callback);
    }

    public interface PermissionCallback {
        void onResult(boolean isAllGranted, List<String> deniedList);
    }
}
