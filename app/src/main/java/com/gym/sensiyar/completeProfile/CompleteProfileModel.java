package com.gym.sensiyar.completeProfile;

public class CompleteProfileModel {
    private String fullName;
    private String field;
    private String state;
    private String city;
    private String birthDay;

    public CompleteProfileModel(String fullName, String field, String state, String city, String birthDay) {
        this.fullName = fullName;
        this.field = field;
        this.state = state;
        this.city = city;
        this.birthDay = birthDay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }
}
