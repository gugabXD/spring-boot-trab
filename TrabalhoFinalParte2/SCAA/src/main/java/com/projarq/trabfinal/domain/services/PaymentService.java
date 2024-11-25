package com.projarq.trabfinal.domain.services;

import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.PaymentRepository;
import com.projarq.trabfinal.domain.entities.PaymentModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    
    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public PaymentModel paymentRegister(PaymentModel payment) {
        return paymentRepository.save(payment);
    }

}
