package com.samad.talukder.androidviewpagerwithcustompageradapter;

public class DataModel {
    private int image;
    private String imageName;

    public DataModel(int image, String imageName) {
        this.image = image;
        this.imageName = imageName;
    }

    public int getImage() {
        return image;
    }

    public String getImageName() {
        return imageName;
    }
}
