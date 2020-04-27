package com.gym.sensiyar.addClass;

import java.sql.Timestamp;

public class AddClassModel {

    private String className;
    private String periodDay;
    private String time;
    private String price;
    private String address;

    public AddClassModel(String className, String periodDay, String time, String price, String address) {
        this.className = className;
        this.periodDay = periodDay;
        this.time = time;
        this.price = price;
        this.address = address;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(String periodDay) {
        this.periodDay = periodDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
