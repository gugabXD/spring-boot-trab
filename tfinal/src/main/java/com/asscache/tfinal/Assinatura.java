package com.asscache.tfinal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Assinatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long code;

    @NotNull(message = "Application name cannot be null")
    @Size(min = 1, max = 50, message = "Application code must be between 1 and 50 characters")
    private String application;

    @NotNull(message = "Customer name cannot be null")
    @Size(min = 1, max = 50, message = "Customer code must be between 1 and 50 characters")
    private String customer;
    @NotNull(message = "Assinatura date cannot be null")
    private LocalDate begin_contract_period;
    @NotNull(message = "End contract period cannot be null")
    private LocalDate end_contract_period;

    public Assinatura(){

    }

    public Assinatura(Long code, String application, String customer, LocalDate begin_contract_period, LocalDate end_contract_period) {
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

    public LocalDate getBegin_contract_period() {
        return begin_contract_period;
    }

    public void setBegin_contract_period(LocalDate begin_contract_period) {
        this.begin_contract_period = begin_contract_period;
    }

    public LocalDate getEnd_contract_period() {
        return end_contract_period;
    }

    public void setEnd_contract_period(LocalDate end_contract_period) {
        this.end_contract_period = end_contract_period;
    }

}
