package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.adapterInterface.repositories.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCustomerRepositoryInterface extends JpaRepository<Customer, Long> {
    Customer findById(long id);
    Customer findByEmail(String email);
    List<Customer> findByName(String nome);
    List<Customer> findAll();
}