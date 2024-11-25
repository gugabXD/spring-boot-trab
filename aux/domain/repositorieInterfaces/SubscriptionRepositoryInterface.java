package main.java.com.asscache.tfinal.domain.repositorieInterfaces;

import main.java.com.asscache.tfinal.domain.entities.SubscriptionModel;

import java.util.List;

public interface SubscriptionRepositoryInterface {
    List<SubscriptionModel> findAll();
    List<SubscriptionModel> findByCustomer(String customer);
    List<SubscriptionModel> findByCustomerCode(long code);
    List<SubscriptionModel> findByApp(String application);
    List<SubscriptionModel> findByAppCode(Long code);
    SubscriptionModel findByCode(long code);

    List<SubscriptionModel> findActiveSubscriptions();
    List<SubscriptionModel> findInactiveSubscriptions();

    Long findLastSubscriptionCode();

    SubscriptionModel save(SubscriptionModel subscription);
}