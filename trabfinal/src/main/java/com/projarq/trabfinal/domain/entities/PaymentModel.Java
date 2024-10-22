package com.projarq.trabfinal.domain.entities;
import java.util.Date;



public class PaymentModel {
    
    private long code;
    private Subscription subscription;
    private Double amountPaid;
    private Date date;
    private String sale;

    public PaymentModel(long code, Subscription subscription, Double amountPaid, Date date, String sale) {
        this.code = code;
        this.subscription = subscription;
        this.amountPaid = amountPaid;
        this.date = date;
        this.sale = sale;
    }

    public long getCode() {
        return code;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public Date getDate() {
        return date;
    }

    public String getSale() {
        return sale;
    }

}