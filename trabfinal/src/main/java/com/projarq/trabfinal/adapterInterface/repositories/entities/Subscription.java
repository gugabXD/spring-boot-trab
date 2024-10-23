package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    private Long code;

    @ManyToOne
    @JoinColumn(name = "application_code", referencedColumnName = "code")
    private App application;

    @ManyToOne
    @JoinColumn(name = "customer_code", referencedColumnName = "code")
    private Customer customer;

    private Date begin_contract_period;
    private Date end_contract_period;

    protected Subscription() {
    }

    public Subscription(Long code, App application, Customer customer, Date begin_contract_period, Date end_contract_period) {
        this.code = code;
        this.application = application;
        this.customer = customer;
        this.begin_contract_period = begin_contract_period;
        this.end_contract_period = end_contract_period;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public App getApplication() {
        return application;
    }

    public void setApplication(App application) {
        this.application = application;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getBegin_contract_period() {
        return begin_contract_period;
    }

    public void setBegin_contract_period(Date begin_contract_period) {
        this.begin_contract_period = begin_contract_period;
    }

    public Date getEnd_contract_period() {
        return end_contract_period;
    }

    public void setEnd_contract_period(Date end_contract_period) {
        this.end_contract_period = end_contract_period;
    }

    public static SubscriptionModel toSubscriptionModel(Subscription subscription) {
        return new SubscriptionModel(
                subscription.getCode(),
                App.toApplicationModel(subscription.getApplication()),
                Customer.toCustomerModel(subscription.getCustomer()),
                subscription.getBegin_contract_period(),
                subscription.getEnd_contract_period()
        );
    }

    public static Subscription fromSubscriptionModel(SubscriptionModel subscriptionModel) {
        return new Subscription(
                subscriptionModel.getCode(),
                App.fromApplicationModel(subscriptionModel.getApplication()),
                Customer.fromCustomerModel(subscriptionModel.getCustomer()),
                subscriptionModel.getBeginContractPeriod(),
                subscriptionModel.getEndContractPeriod()
        );
    }

}
