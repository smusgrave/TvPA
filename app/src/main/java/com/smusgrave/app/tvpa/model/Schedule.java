package com.smusgrave.app.tvpa.model;

import java.util.ArrayList;
import java.util.List;

public class Schedule {

    private String time;
    private List<String> days = new ArrayList<>();

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
