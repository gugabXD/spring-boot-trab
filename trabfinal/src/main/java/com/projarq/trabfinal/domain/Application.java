package com.projarq.trabfinal.domain;

public class Application {
    private String name;
    private long code;
    private double monthCost;

    public Application(long code, String name, double monthCost) {
        this.code = code;
        this.name = name;
        this.monthCost = monthCost;
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public double getMonthCost() {
        return monthCost;
    }
}
