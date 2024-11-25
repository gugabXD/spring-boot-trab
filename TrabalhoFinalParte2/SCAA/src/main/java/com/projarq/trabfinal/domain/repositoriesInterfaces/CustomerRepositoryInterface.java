package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.CustomerModel;

import java.util.List;

public interface CustomerRepositoryInterface {
    List<CustomerModel> findByName(String nome);
    CustomerModel findByEmail(String email);
    List<CustomerModel> findAll();
    CustomerModel findById(long id);
}
