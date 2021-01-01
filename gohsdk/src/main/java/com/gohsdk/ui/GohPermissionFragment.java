package com.gohsdk.ui;

import android.app.Fragment;
import android.content.pm.PackageManager;
import android.os.Build;

import com.gohsdk.utils.PermissionUtil;

import java.util.ArrayList;
import java.util.List;

public class GohPermissionFragment extends Fragment {

    private PermissionUtil.PermissionCallback callback;

    private static final int PERMISSION_REQUEST_CODE = 1;

    public void apply(String[] permissions, PermissionUtil.PermissionCallback callback) {
        this.callback = callback;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            List<String> deniedList = new ArrayList<>();
            for (int i = 0; i < grantResults.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    deniedList.add(permissions[i]);
                }
            }
            boolean isAllGranted = deniedList.isEmpty();
            callback.onResult(isAllGranted, deniedList);
        }
    }
}
