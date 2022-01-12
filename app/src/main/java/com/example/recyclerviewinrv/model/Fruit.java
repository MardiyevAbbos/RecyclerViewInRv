package com.example.recyclerviewinrv.model;

import java.util.ArrayList;

public class Fruit {
    private int image;
    private ArrayList<FruitSub> imageSubs;

    public Fruit(int image, ArrayList<FruitSub> imageSubs) {
        this.image = image;
        this.imageSubs = imageSubs;
    }

    public Fruit() {

    }

    public int getImage() {
        return image;
    }

    public ArrayList<FruitSub> getImageSubs() {
        return imageSubs;
    }

}
