package com.gohsdk.net;

import com.gohsdk.entities.GohGameConfig;
import com.gohsdk.utils.ToastUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class GohRepository {

    private final Gson gson = new Gson();

    public void init(GohGameConfig config) {
        try {
            String json = gson.toJson(config);
            JSONObject obj = new JSONObject(json);
            GohNet.post(new ApiInit(), obj, new GohNet.Callback() {
                @Override
                public void onResponse(JSONObject response) {
                    boolean status = response.optBoolean("status");
                    if (status) {
                        // TODO
                    } else {
                        ToastUtil.show(response.optString("data"));
                    }
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
