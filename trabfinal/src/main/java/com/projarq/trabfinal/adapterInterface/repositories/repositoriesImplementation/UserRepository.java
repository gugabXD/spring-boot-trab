package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;


import com.projarq.trabfinal.adapterInterface.repositories.entities.User;
import com.projarq.trabfinal.domain.entities.UserModel;
import com.projarq.trabfinal.domain.repositoriesInterfaces.UserRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaUserRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository implements UserRepositoryInterface {
    private JpaUserRepositoryInterface jpaUserRepositoryInterface;

    @Autowired
    public UserRepository(JpaUserRepositoryInterface jpaUserRepositoryInterface) {
        this.jpaUserRepositoryInterface = jpaUserRepositoryInterface;
    }

    @Override
    public List<UserModel> findByName(String name) {
        return jpaUserRepositoryInterface.findByName(name).stream().map(User::toUserModel).toList();
    }

}
