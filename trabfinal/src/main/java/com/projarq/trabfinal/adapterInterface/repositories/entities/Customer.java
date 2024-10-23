package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.CustomerModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Long code;
    private String name;
    private String email;

    protected Customer() {
    }

    public Customer(Long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static CustomerModel toCustomerModel(Customer customer) {
        return new CustomerModel(customer.getCode(), customer.getName(), customer.getEmail());
    }

    public static Customer fromCustomerModel(CustomerModel customerModel) {
        return new Customer(customerModel.getCode(), customerModel.getName(), customerModel.getEmail());
    }

}
