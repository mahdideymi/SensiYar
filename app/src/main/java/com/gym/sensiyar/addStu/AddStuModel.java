package com.gym.sensiyar.addStu;

import java.util.ArrayList;

public class AddStuModel {
    private String fullName;
    private String regDate;
    private String price;
    private String phoneNumber;
    private String parentPhoneNumber;
    private String fatherName;
    private String fatherBusiness;
    private String motherBusiness;
    private String motherName;
    private ArrayList<String> hitory;
    private String note;
    private String bimeNumber;
    private Boolean priceStatus;

    public AddStuModel(String fullName, String regDate, String price, String phoneNumber,
                       String parentPhoneNumber, String fatherName, String fatherBusiness,
                       String motherBusiness, String motherName, ArrayList<String> hitory,
                       String note) {
        this.fullName = fullName;
        this.regDate = regDate;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.parentPhoneNumber = parentPhoneNumber;
        this.fatherName = fatherName;
        this.fatherBusiness = fatherBusiness;
        this.motherBusiness = motherBusiness;
        this.motherName = motherName;
        this.hitory = hitory;
        this.note = note;
    }

    boolean isPhoneValidate(String phoneNumber) {
        //Todo: phone number validator should be implement
        if (phoneNumber.charAt(0) != '0')
            return false;
        else if (phoneNumber.charAt(1) != '9') {
            return false;
        } else if(phoneNumber.length() != 11) {
            return false;
        }
        return true;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFatherBusiness() {
        return fatherBusiness;
    }

    public void setFatherBusiness(String fatherBusiness) {
        this.fatherBusiness = fatherBusiness;
    }

    public String getMotherBusiness() {
        return motherBusiness;
    }

    public void setMotherBusiness(String motherBusiness) {
        this.motherBusiness = motherBusiness;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public ArrayList<String> getHitory() {
        return hitory;
    }

    public void setHitory(ArrayList<String> hitory) {
        this.hitory = hitory;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBimeNumber() {
        return bimeNumber;
    }

    public void setBimeNumber(String bimeNumber) {
        this.bimeNumber = bimeNumber;
    }

    public Boolean isPriceStatus() {
        return priceStatus;
    }

    public void setPriceStatus(Boolean priceStatus) {
        this.priceStatus = priceStatus;
    }
}
