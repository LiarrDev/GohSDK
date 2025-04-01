package com.gohsdk.report;

public class GohReport extends InternalReport{

    private GohReport() {
    }

    private static final GohReport instance = new GohReport();

    public static GohReport get() {
        return instance;
    }
}
