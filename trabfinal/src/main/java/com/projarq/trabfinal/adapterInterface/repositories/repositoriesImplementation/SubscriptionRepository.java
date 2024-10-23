package com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation;


import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Customer;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;
import com.projarq.trabfinal.domain.entities.ApplicationModel;
import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaSubscriptionRepositoryInterface;
import com.projarq.trabfinal.domain.repositoriesInterfaces.SubscriptionRepositoryInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionRepository implements SubscriptionRepositoryInterface{
    
    private JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface;

    @Override
    public List<SubscriptionModel> findByApp(ApplicationModel application) {
        return jpaSubscriptionRepositoryInterface.findByApp(App.fromApplicationModel(application)).stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public List<SubscriptionModel> findByAppCode(Long code) {
        return jpaSubscriptionRepositoryInterface.findByAppCode(code).stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public List<SubscriptionModel> findActiveSubscriptions() {
        return jpaSubscriptionRepositoryInterface.findActiveSubscriptions().stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public List<SubscriptionModel> findInactiveSubscriptions() {
        return jpaSubscriptionRepositoryInterface.findInactiveSubscriptions().stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Autowired
    public SubscriptionRepository(JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface) {
        this.jpaSubscriptionRepositoryInterface = jpaSubscriptionRepositoryInterface;
    }

    @Override
    public List<SubscriptionModel> findAll() {
        return jpaSubscriptionRepositoryInterface.findAll().stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public List<SubscriptionModel> findByCustomer(CustomerModel customer) {
        return jpaSubscriptionRepositoryInterface.findByCustomer(Customer.fromCustomerModel(customer)).stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public List<SubscriptionModel> findByCustomerCode(long id) {
        return jpaSubscriptionRepositoryInterface.findByCustomerCode(id).stream().map(Subscription::toSubscriptionModel).toList();
    }

    @Override
    public SubscriptionModel findByCode(long code) {
        return jpaSubscriptionRepositoryInterface.findById(code)
                .map(Subscription::toSubscriptionModel)
                .orElse(null);
    }

    @Override
    public Long findLastSubscriptionCode() {
        return jpaSubscriptionRepositoryInterface.findLastSubscriptionCode();
    }

    @Override
    public SubscriptionModel save(SubscriptionModel subscription) {
        return Subscription.toSubscriptionModel(jpaSubscriptionRepositoryInterface.save(Subscription.fromSubscriptionModel(subscription)));
    }

}
