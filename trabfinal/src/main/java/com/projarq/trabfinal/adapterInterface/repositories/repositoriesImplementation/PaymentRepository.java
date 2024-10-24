package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaPaymentRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Payment;
import com.projarq.trabfinal.domain.repositoriesInterfaces.PaymentRepositoryInterface;
import com.projarq.trabfinal.domain.entities.PaymentModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PaymentRepository implements PaymentRepositoryInterface {

    private JpaPaymentRepositoryInterface jpaPaymentRepositoryInterface;

    @Autowired
    public PaymentRepository(JpaPaymentRepositoryInterface jpaPaymentRepositoryInterface) {
        this.jpaPaymentRepositoryInterface = jpaPaymentRepositoryInterface;
    }

    @Override
    public PaymentModel save(PaymentModel payment) {
        return Payment.toPaymentModel(jpaPaymentRepositoryInterface.save(Payment.fromPaymentModel(payment)));
    }

    @Override
    public List<PaymentModel> findBySubscriptionCode(SubscriptionModel subscription) {
        return jpaPaymentRepositoryInterface.findBySubscriptionCode(Subscription.fromSubscriptionModel(subscription))
                .stream().map(Payment::toPaymentModel).toList();
    }

    @Override
    public List<PaymentModel> findByDate(Date dataPagamento) {
        return jpaPaymentRepositoryInterface.findByDate(dataPagamento).stream().map(Payment::toPaymentModel).toList();
    }

}
