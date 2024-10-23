package com.projarq.trabfinal.domain.entities;

public class CustomerModel {

    private String name;
    private Long code;
    private String email;

    public CustomerModel(Long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Long getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

}
