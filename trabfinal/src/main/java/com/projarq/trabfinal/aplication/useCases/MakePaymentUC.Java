package com.projarq.trabfinal.aplication.useCases;

import org.springframework.stereotype.Component;

import com.projarq.trabfinal.domain.models.Payment;
import com.projarq.trabfinal.domain.repositories.PaymentRepository;

@Component
public class MakePaymentUC {

    private final PaymentRepository paymentRepository;
    private final UserService userService;

    public MakePaymentUC(PaymentRepository paymentRepository, UserService userService) {
        this.paymentRepository = paymentRepository;
        this.userService = userService;
    }

    public Payment makePayment(Payment payment) {

        return null;

    }
}