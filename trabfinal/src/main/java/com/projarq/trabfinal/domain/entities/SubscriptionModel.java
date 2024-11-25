package com.projarq.trabfinal.domain.entities;

import java.util.Date;

public class SubscriptionModel {

    private Long code;
    private ApplicationModel application;
    private CustomerModel customer;
    private Date beginContractPeriod;
    private Date endContractPeriod;

    public SubscriptionModel(Long code, ApplicationModel application, CustomerModel customer, Date beginContractPeriod, Date endContractPeriod) {
        this.code = code;
        this.application = application;
        this.customer = customer;
        this.beginContractPeriod = beginContractPeriod;
        this.endContractPeriod = endContractPeriod;
    }

    public Long getCode() {
        return code;
    }

    public ApplicationModel getApplication() {
        return application;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public Date getBeginContractPeriod() {
        return beginContractPeriod;
    }

    public Date getEndContractPeriod() {
        return endContractPeriod;
    }

    public void setEndContractPeriod(Date endContractPeriod) {
        this.endContractPeriod = endContractPeriod;
    }
    
    public boolean isActive() {
        if (beginContractPeriod == null || endContractPeriod == null) {
            return false;
        }
        Date now = new Date();
        return beginContractPeriod.before(now) && endContractPeriod.after(now);
    }

    public String getStatus() {
        return isActive() ? "ATIVA" : "CANCELADA";
    }

    @Override
    public String toString(){
        return "SubscriptionModel{" +
                "code=" + code +
                ", application=" + application +
                ", customer=" + customer +
                ", beginContractPeriod=" + beginContractPeriod +
                ", endContractPeriod=" + endContractPeriod +
                " isActive=" + getStatus() +
                '}';
    }
}
