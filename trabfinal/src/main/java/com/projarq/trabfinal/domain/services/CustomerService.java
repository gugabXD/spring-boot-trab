package com.projarq.trabfinal.domain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.CustomerRepository;
import com.projarq.trabfinal.domain.entities.CustomerModel;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerModel> findAll() {
        return customerRepository.findAll();
    }

}
