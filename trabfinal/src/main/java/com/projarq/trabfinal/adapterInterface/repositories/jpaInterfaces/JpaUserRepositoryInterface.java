package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projarq.trabfinal.adapterInterface.repositories.entities.User;

public interface JpaUserRepositoryInterface extends JpaRepository<User, String> {
    List<User> findByLogin(String);

}
