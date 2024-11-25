package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.PaymentModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;

import java.util.Date;
import java.util.List;

public interface PaymentRepositoryInterface {
    PaymentModel save(PaymentModel Payment);

    List<PaymentModel> findBySubscriptionCode(SubscriptionModel Subscription);

    List<PaymentModel> findByDate(Date date);

}