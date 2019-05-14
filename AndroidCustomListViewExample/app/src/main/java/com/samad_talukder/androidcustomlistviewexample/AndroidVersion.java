package com.samad_talukder.androidcustomlistviewexample;

public class AndroidVersion {
    private int androidVersionImage;
    private String  androidVersionName;
    private String androidVersion;

    public AndroidVersion(int androidVersionImage, String androidVersionName, String androidVersion) {
        this.androidVersionImage = androidVersionImage;
        this.androidVersionName = androidVersionName;
        this.androidVersion = androidVersion;
    }

    public int getAndroidVersionImage() {
        return androidVersionImage;
    }

    public void setAndroidVersionImage(int androidVersionImage) {
        this.androidVersionImage = androidVersionImage;
    }

    public String getAndroidVersionName() {
        return androidVersionName;
    }

    public void setAndroidVersionName(String androidVersionName) {
        this.androidVersionName = androidVersionName;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }
}
