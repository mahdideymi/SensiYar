package com.gym.sensiyar.classDetail.editClass;

public class EditClassModel {

    private String className;
    private int periodDay;
    private String time;

    public EditClassModel(String className, int periodDay, String time) {
        this.className = className;
        this.periodDay = periodDay;
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(int periodDay) {
        this.periodDay = periodDay;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
