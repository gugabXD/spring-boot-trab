package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.domain.entities.PaymentModel; 
import com.projarq.trabfinal.domain.entities.SubscriptionModel;

import java.util.Date;
import java.util.List;

public interface JpaPaymentRepositoryInterface {
    PaymentModel save(PaymentModel payment);
    List<PaymentModel> findByAssinatura(SubscriptionModel subscription);
    List<PaymentModel> findByDataPagamento(Date paymentDate);
    
}
