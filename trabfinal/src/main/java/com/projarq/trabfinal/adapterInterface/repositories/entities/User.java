package com.projarq.trabfinal.adapterInterface.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String user_name;
    private String password;

    protected User() {
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getuser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
