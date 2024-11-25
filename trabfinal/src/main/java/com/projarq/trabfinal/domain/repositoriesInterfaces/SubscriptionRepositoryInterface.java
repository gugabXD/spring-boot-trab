package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import java.util.List;

public interface SubscriptionRepositoryInterface {
    List<SubscriptionModel> findAll();
    List<SubscriptionModel> findByCustomer(CustomerModel customer);
    List<SubscriptionModel> findByCustomerCode(long code);
    List<SubscriptionModel> findByApp(ApplicationModel application);
    List<SubscriptionModel> findByAppCode(Long code);

    SubscriptionModel findByCode(long code);

    List<SubscriptionModel> findActiveSubscriptions();

    List<SubscriptionModel> findInactiveSubscriptions();

    Long findLastSubscriptionCode();

    SubscriptionModel save(SubscriptionModel subscription);
}