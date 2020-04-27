package com.gym.sensiyar.home.classList;

public class ClassListModel {
    private String className;
    private String time;
    private String period;

    public ClassListModel() {
    }

    public ClassListModel(String className, String time, String period) {
        this.className = className;
        this.time = time;
        this.period = period;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
