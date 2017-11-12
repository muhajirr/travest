package com.mobile.travest;

/**
 * Created by haimax on 11/12/17.
 */

public class Place {
    int imageID, price;
    String name, location;

    public Place(int imageID, String name, String location, int price) {
        this.imageID = imageID;
        this.price = price;
        this.name = name;
        this.location = location;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
