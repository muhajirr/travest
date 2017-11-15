package com.mobile.travest;

/**
 * Created by haimax on 11/16/17.
 */

public class App {
    int imgID;
    String name;

    public App(int imgID, String name) {
        this.imgID = imgID;
        this.name = name;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
