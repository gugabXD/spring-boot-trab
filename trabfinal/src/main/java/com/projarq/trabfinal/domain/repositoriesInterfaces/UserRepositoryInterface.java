package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.UserModel;

import java.util.List;

public interface UserRepositoryInterface {
    List<UserModel> findByName(String name);

}
