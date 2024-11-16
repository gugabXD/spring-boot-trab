package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @Table(name = "users")
public class User {
    @Id
    @Column(name = "user_name")
    private String user_name;
    private String password;

    protected User() {
    }

    public User(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserModel toUserModel(User user){
        return new UserModel(user.getUser_name(), user.getPassword());
    }

    public static User fromUserModel(UserModel userModel){
        return new User(userModel.getUser(),userModel.getPassword());
    }

}
