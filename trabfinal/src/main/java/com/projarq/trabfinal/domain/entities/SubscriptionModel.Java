import java.util.Date;

package com.projarq.trabfinal.domain.entities;

public class Subscription {
    
    private long code;
    private Application application;
    private Customer customer;
    private Date beginContractPeriod;
    private Date endContractPeriod;

    public Subscription(long code, Application application, Customer customer, Date beginContractPeriod, Date endContractPeriod) {
        this.code = code;
        this.application = application;
        this.customer = customer;
        this.beginContractPeriod = beginContractPeriod;
        this.endContractPeriod = endContractPeriod;
    }

    public long getCode() {
        return code;
    }

    public Application getApplication() {
        return application;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getBeginContractPeriod() {
        return beginContractPeriod;
    }

    public Date getEndContractPeriod() {
        return endContractPeriod;
    }
}
