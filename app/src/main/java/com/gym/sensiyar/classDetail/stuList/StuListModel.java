package com.gym.sensiyar.classDetail.stuList;

public class StuListModel {
    private String avatar;
    private String name;
    private Boolean priceStatus;
    private String regDate;

    public StuListModel(String avatar, String name, Boolean priceStatus, String regDate) {
        this.avatar = avatar;
        this.name = name;
        this.priceStatus = priceStatus;
        this.regDate = regDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getPriceStatus() {
        return priceStatus;
    }

    public void setPriceStatus(Boolean priceStatus) {
        this.priceStatus = priceStatus;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
}
