package main.java.com.asscache.tfinal;

import main.java.com.asscache.tfinal.domain.entities.SubscriptionModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    private Long code;

    @NotNull(message = "Application name cannot be null")
    @Size(min = 1, max = 50, message = "Application code must be between 1 and 50 characters")
    private String application;

    @NotNull(message = "Customer name cannot be null")
    @Size(min = 1, max = 50, message = "Customer code must be between 1 and 50 characters")
    private String customer;
    @NotNull(message = "Subscription date cannot be null")
    private Date begin_contract_period;
    @NotNull(message = "End contract period cannot be null")
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

}
