package com.company.app.entities;

import java.io.Serializable;

public class Birthday implements Serializable {

    public static final String DELIMITER = "\\.";
    private static final long serialVersionUID = 1L;
    private String day;
    private String month;

    public Birthday() {
    }

    public Birthday(String day, String month) {
        this.day = day;
        this.month = month;
    }

    public static Birthday of(String string) {
        String[] split = string.split(DELIMITER);
        return new Birthday(split[0], split[1]);
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return day + "." + month;
    }
}
