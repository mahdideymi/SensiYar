package com.gym.sensiyar.enterPhone;

public class EnterPhoneModel {
    private String strPhoneNumber;

    EnterPhoneModel(String email) {
        strPhoneNumber = email;
    }

    String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber(String strPhoneNumber) {
        this.strPhoneNumber = strPhoneNumber;
    }


    boolean isPhoneValidate() {
        //Todo: phone number validator should be implement
        if (getStrPhoneNumber().charAt(0) != '0')
            return false;
        else if (getStrPhoneNumber().charAt(1) != '9') {
            return false;
        } else if(getStrPhoneNumber().length() != 11) {
            return false;
        }
        return true;
    }

}
