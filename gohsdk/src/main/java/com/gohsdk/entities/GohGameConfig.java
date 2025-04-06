package com.gohsdk.entities;

import com.google.gson.annotations.SerializedName;

public class GohGameConfig {

    @SerializedName("gid")
    private int gId;
    @SerializedName("pid")
    private int pId;
    @SerializedName("areaid")
    private int areaId;
    @SerializedName("osid")
    private int osId;
    @SerializedName("client")
    private int client;
    @SerializedName("pkid")
    private int pkId;
    @SerializedName("pcid")
    private int pcId;
    @SerializedName("cid")
    private int cId;
    @SerializedName("adid")
    private int adId;
    @SerializedName("sdkVersion")
    private String sdkVersion;

    public int getGId() {
        return gId;
    }

    public void setGId(int gId) {
        this.gId = gId;
    }

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getOsId() {
        return osId;
    }

    public void setOsId(int osId) {
        this.osId = osId;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getPkId() {
        return pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public int getPcId() {
        return pcId;
    }

    public void setPcId(int pcId) {
        this.pcId = pcId;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    @Override
    public String toString() {
        return "GohGameConfig{" +
                "gId=" + gId +
                ", pId=" + pId +
                ", areaId=" + areaId +
                ", osId=" + osId +
                ", client=" + client +
                ", pkId=" + pkId +
                ", pcId=" + pcId +
                ", cId=" + cId +
                ", adId=" + adId +
                ", sdkVersion='" + sdkVersion + '\'' +
                '}';
    }
}
