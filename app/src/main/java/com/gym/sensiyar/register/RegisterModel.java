package com.gym.sensiyar.register;

import android.util.Patterns;

public class RegisterModel {

    private String strEmail;
    private String strPass;
    private String strConfirmPass;

    public RegisterModel(String email, String pass , String confirmPass) {
        strEmail = email;
        strPass = pass;
        strConfirmPass = confirmPass;

    }

    public String getStrConfirmPass() {
        return strConfirmPass;
    }

    public void setStrConfirmPass(String strConfirmPass) {
        this.strConfirmPass = strConfirmPass;
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getStrPass() {
        return strPass;
    }

    public void setStrPass(String strPass) {
        this.strPass = strPass;
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getStrEmail()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getStrPass().length() > 4;
    }
}
