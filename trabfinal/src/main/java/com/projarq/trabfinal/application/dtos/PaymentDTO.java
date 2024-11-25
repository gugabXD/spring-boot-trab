package com.projarq.trabfinal.application.dtos;


public class PaymentDTO {
    private String day;
    private String month;
    private String year;
    private Double paidValue;
    private Long subsCode;

    public PaymentDTO(String day, String month, String year, Double paidValue, Long subsCode) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.paidValue = paidValue;
        this.subsCode = subsCode;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public Double getPaidValue() {
        return paidValue;
    }

    public Long getSubsCode() {
        return subsCode;
    }

}
