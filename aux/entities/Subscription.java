package main.java.com.asscache.tfinal.adapterInterface.repositories.entities;

import main.java.com.asscache.tfinal.domain.entities.SubscriptionModel;

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

    private String application;
    private String customer;
    private Date begin_contract_period;
    private Date end_contract_period;

    protected Subscription() {
    }

    public Subscription(Long code, String application, String customer, Date begin_contract_period, Date end_contract_period) {
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

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
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
                subscription.getApplication(),
                subscription.getCustomer(),
                subscription.getBegin_contract_period(),
                subscription.getEnd_contract_period()
        );
    }

    public static Subscription fromSubscriptionModel(SubscriptionModel subscriptionModel) {
        return new Subscription(
                subscriptionModel.getCode(),
                subscriptionModel.getApplication(),
                subscriptionModel.getCustomer(),
                subscriptionModel.getBeginContractPeriod(),
                subscriptionModel.getEndContractPeriod()
        );
    }

}
