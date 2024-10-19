package com.projarq.trabfinal.domain.entities;

public class CustomerModel {

    private String name;
    private long code;
    private String email;

    public CustomerModel(long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

}
