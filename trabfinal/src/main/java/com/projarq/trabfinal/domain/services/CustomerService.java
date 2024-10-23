package com.projarq.trabfinal.domain.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

        private ClienteRepositoryImpl clienteRepositoryImpl;

    @Autowired
    public CustomerService(ClienteRepositoryImpl clienteRepositoryImpl) {
        this.clienteRepositoryImpl = clienteRepositoryImpl;
    }

    public List<ClienteModel> findAll() {
        return clienteRepositoryImpl.findAll();
    }

    
}
