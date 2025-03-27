package com.gohsdk.entities;

public class GohGameConfig {

    private String gameId;
    private String sdkVersion;

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
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
                "gameId='" + gameId + '\'' +
                ", sdkVersion='" + sdkVersion + '\'' +
                '}';
    }
}
