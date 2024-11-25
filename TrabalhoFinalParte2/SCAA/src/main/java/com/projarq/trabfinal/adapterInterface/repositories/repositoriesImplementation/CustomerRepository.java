package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaCustomerRepositoryInterface;
import com.projarq.trabfinal.domain.repositoriesInterfaces.CustomerRepositoryInterface;
import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepositoryInterface {

    private JpaCustomerRepositoryInterface jpaCustomerRepositoryInterface;

    @Autowired
    public CustomerRepository (JpaCustomerRepositoryInterface jpaCustomerRepositoryInterface) {
        this.jpaCustomerRepositoryInterface = jpaCustomerRepositoryInterface;
    }

    @Override
    public List<CustomerModel> findByName(String name) {
        return jpaCustomerRepositoryInterface.findByName(name).stream().map(Customer::toCustomerModel).toList();
    }

    @Override
    public CustomerModel findByEmail(String email) {
        return Customer.toCustomerModel(jpaCustomerRepositoryInterface.findByEmail(email));
    }

    @Override
    public List<CustomerModel> findAll() {
        return jpaCustomerRepositoryInterface.findAll().stream().map(Customer::toCustomerModel).toList();
    }

    @Override
    public CustomerModel findById(long id) {
        return Customer.toCustomerModel(jpaCustomerRepositoryInterface.findById(id));
    }
}