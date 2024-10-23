package com.projarq.trabfinal.domain.entities;

import java.util.Date;


public class PaymentModel {
    
    private Long code;
    private SubscriptionModel subscription;
    private Double amountPaid;
    private Date date;
    private String sale;

    public PaymentModel(Long code, SubscriptionModel subscription, Double amountPaid, Date date, String sale) {
        this.code = code;
        this.subscription = subscription;
        this.amountPaid = amountPaid;
        this.date = date;
        this.sale = sale;
    }

    public Long getCode() {
        return code;
    }

    public SubscriptionModel getSubscription() {
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
