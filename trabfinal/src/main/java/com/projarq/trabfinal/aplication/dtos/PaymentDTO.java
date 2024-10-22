package com.projarq.trabfinal.aplication.dtos;


public class PaymentDTO {
    private Long id;
    private double amount;
    private String status;

    public PaymentDTO(Long id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }


}
