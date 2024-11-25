package com.projarq.trabfinal.domain.entities;

public class UserModel {
    
    private String userName;
    private String password;

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUser() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}