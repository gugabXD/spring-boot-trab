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
}
