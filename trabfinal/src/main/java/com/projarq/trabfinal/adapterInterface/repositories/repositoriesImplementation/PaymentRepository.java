package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;

import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaPaymentRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaApplicationRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Payment;
import com.projarq.trabfinal.domain.repositoriesInterfaces.PaymentRepositoryInterface;
import com.projarq.trabfinal.domain.entities.PaymentModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class PaymentRepository implements PaymentRepositoryInterface{

    private final JpaApplicationRepositoryInterface jpaApplicationRepositoryInterface;
    private JpaPaymentRepositoryInterface jpaPaymentRepositoryInterface;

    @Autowired
    public PaymentRepository(JpaPaymentRepositoryInterface jpaPaymentRepositoryInterface, JpaApplicationRepositoryInterface jpaApplicationRepositoryInterface) {
        this.jpaPaymentRepositoryInterface = jpaPaymentRepositoryInterface;
        this.jpaApplicationRepositoryInterface = jpaApplicationRepositoryInterface;
    }

    @Override
    public PaymentModel save(PaymentModel payment) {
        return Payment.toPagamentoModel(jpaPaymentRepositoryInterface.save(Payment.fromPagamentoModel(payment)));
    }

    @Override
    public List<PagamentoModel> findByAssinatura(SubscriptionModel assinatura) {
        return pagamentoRepositoryJpa.findByAssinatura(Subscription.fromSubscriptionModel(subscription)).stream().map(Payment::toPagamentoModel).toList();
    }

    @Override
    public List<PaymentModel> findByPymentDate(Date dataPagamento) {
        return jpaPaymentRepositoryInterface.findByPymentDate(dataPagamento).stream().map(Payment::toPagamentoModel).toList();
    }
    
}
