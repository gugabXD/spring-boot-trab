package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.domain.entities.PaymentModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Payment;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentRepositoryInterface extends JpaRepository <Payment, Long> {
    List<Payment> findBySubscriptionCode(Subscription subscription);
    List<Payment> findByDate(Date daate);
    
    Payment save(Payment payment);
}
