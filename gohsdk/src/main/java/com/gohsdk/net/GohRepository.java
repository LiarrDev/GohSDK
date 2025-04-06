package com.gohsdk.net;

import com.gohsdk.entities.GohGameConfig;
import com.gohsdk.utils.HttpUtil;
import com.gohsdk.utils.LogUtil;
import com.google.gson.Gson;

import java.util.HashMap;

public class GohRepository {

    private final Gson gson = new Gson();

    public void init(GohGameConfig config) {
        HashMap<String, String> map = new HashMap<>();
        map.put("gid", String.valueOf(config.getGId()));
        map.put("pid", String.valueOf(config.getPId()));
        map.put("areaid", String.valueOf(config.getAreaId()));
        map.put("osid", String.valueOf(config.getOsId()));
        map.put("client", String.valueOf(config.getClient()));
        map.put("pkid", String.valueOf(config.getPkId()));
        map.put("pcid", String.valueOf(config.getPcId()));
        map.put("cid", String.valueOf(config.getCId()));
        map.put("adid", String.valueOf(config.getAdId()));

        LogUtil.e("map: " + map);
        HttpUtil.post(new ApiInit(), map, new HttpUtil.Callback() {
            @Override
            public void onResponse(String response) {
                LogUtil.e("rsp: " + response);
            }
        });
    }
}
