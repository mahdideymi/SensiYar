package com.gym.sensiyar.withoutInsurance;

public class InsuranceModel {
    private String name;
    private String bimeNumber;
    private String bimeDate;

    InsuranceModel() {

    }

    public InsuranceModel(String name, String bimeNumber, String bimeDate) {
        this.name = name;
        this.bimeNumber = bimeNumber;
        this.bimeDate = bimeDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBimeNumber() {
        return bimeNumber;
    }

    public void setBimeNumber(String bimeNumber) {
        this.bimeNumber = bimeNumber;
    }

    public String getBimeDate() {
        return bimeDate;
    }

    public void setBimeDate(String bimeDate) {
        this.bimeDate = bimeDate;
    }
}
