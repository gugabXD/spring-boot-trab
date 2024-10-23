package com.projarq.trabfinal.domain.entities;

public class UserModel {
    
    private String user;
    private String password;

    public UserModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}