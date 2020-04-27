package com.gym.sensiyar.bedehkar;

public class BedehkarModel {
    private String name;
    private String price;
    private String paying;

    public BedehkarModel(String name, String price, String paying) {
        this.name = name;
        this.price = price;
        this.paying = paying;
    }

    public BedehkarModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPaying() {
        return paying;
    }

    public void setPaying(String paying) {
        this.paying = paying;
    }
}
