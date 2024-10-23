package com.projarq.trabfinal.domain.entities;

public class ApplicationModel {
    
    private String name;
    private Long code;
    private Double monthCost;

    public ApplicationModel(Long code, String name, Double monthCost) {
        this.code = code;
        this.name = name;
        this.monthCost = monthCost;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getmonthCost() {
        return monthCost;
    }

    public void setmonthCost(Double monthCost) {
        this.monthCost = monthCost;
    }
    
}
