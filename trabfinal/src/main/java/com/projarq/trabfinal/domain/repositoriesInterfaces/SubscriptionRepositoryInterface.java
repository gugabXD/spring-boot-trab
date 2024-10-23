package com.projarq.trabfinal.domain.repositoriesInterfaces;

import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.domain.entities.ApplicationModel;

import java.util.List;

public interface SubscriptionRepositoryInterface {
    List<SubscriptionModel> findAll();
    List<SubscriptionModel> findByCustomer(CustomerModel customer);
    List<SubscriptionModel> findByCustomerCode(long code);
    List<SubscriptionModel> findByApplication(ApplicationModel application);
    List<SubscriptionModel> findByApplicationCode(Long code);

    SubscriptionModel findByCode(long code);

    List<SubscriptionModel> findActiveSubscription();

    List<SubscriptionModel> findInactiveSubscription();

    Long findLastSubscriptionCode();

    SubscriptionModel save(SubscriptionModel subscription);
}