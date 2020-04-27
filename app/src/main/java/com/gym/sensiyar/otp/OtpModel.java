package com.gym.sensiyar.otp;

public class OtpModel {
    private String otp;

    OtpModel(String otp) {
        this.otp = otp;
    }

    String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    boolean isOtpValidate(){
        return getOtp().length() == 5;
    }
}
