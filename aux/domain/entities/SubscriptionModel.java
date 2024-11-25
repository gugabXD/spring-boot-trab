package main.java.com.asscache.tfinal.domain.entities;

import java.util.Date;

public class SubscriptionModel {

    private Long code;
    private String application;
    private String customer;
    private Date beginContractPeriod;
    private Date endContractPeriod;

    public SubscriptionModel(Long code, String application, String customer, Date beginContractPeriod, Date endContractPeriod) {
        this.code = code;
        this.application = application;
        this.customer = customer;
        this.beginContractPeriod = beginContractPeriod;
        this.endContractPeriod = endContractPeriod;
    }

    public Long getCode() {
        return code;
    }

    public String getApplication() {
        return application;
    }

    public String getCustomer() {
        return customer;
    }

    public Date getBeginContractPeriod() {
        return beginContractPeriod;
    }

    public Date getEndContractPeriod() {
        return endContractPeriod;
    }

    @Override
    public String toString(){
        return "SubscriptionModel{" +
                "code=" + code +
                ", application=" + application +
                ", customer=" + customer +
                ", beginContractPeriod=" + beginContractPeriod +
                ", endContractPeriod=" + endContractPeriod +
                '}';
    }
}
