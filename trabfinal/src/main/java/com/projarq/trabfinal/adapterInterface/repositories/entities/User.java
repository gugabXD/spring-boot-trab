package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.UserModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "userName")
    private String userName;
    private String password;

    protected User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUser() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUser(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static UserModel toUserModel(User user){
        return new UserModel(user.getUser(), user.getPassword());
    }

    public static User fromUserModel(UserModel userModel){
        return new User(userModel.getUser(),userModel.getPassword());
    }

}
