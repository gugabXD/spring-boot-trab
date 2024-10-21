package com.projarq.trabfinal.domain.entities.ApplicationModel;

public class ApplicationModel {
    
    private String name;
    private long code;
    private double monthCost;

    public ApplicationModel(long code, String name, double monthCost) {
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