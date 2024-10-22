package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.adapterInterface.repositories.models.SubscriptionModel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Subscription {

    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;

    protected Subscription() {}

    public Subscription(SubscriptionModel subscriptionModel) {
        this.id = subscriptionModel.getId();
        this.name = subscriptionModel.getName();
        this.description = subscriptionModel.getDescription();
        this.price = subscriptionModel.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}