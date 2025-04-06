package com.gohsdk.net;

public class GohBaseApi {

    private final static String baseUrl = "http://user.gzfenghou.cn/";
    private final String name;

    public GohBaseApi(String name) {
        this.name = name;
    }

    public String getUrl() {
        return baseUrl + name;
    }
}
