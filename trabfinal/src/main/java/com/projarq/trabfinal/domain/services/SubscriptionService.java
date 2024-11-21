package com.projarq.trabfinal.domain.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;

import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaSubscriptionRepositoryInterface;
import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.ApplicationRepository;
import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.CustomerRepository;
import com.projarq.trabfinal.adapterInterface.repositories.repositoriesImplementation.SubscriptionRepository;
import com.projarq.trabfinal.domain.entities.ApplicationModel;
import com.projarq.trabfinal.domain.entities.CustomerModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;

import java.util.Date;

@Service
public class SubscriptionService {

    private JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface;

    private SubscriptionRepository subscriptionRepository;
    private ApplicationRepository applicationRepository;
    private CustomerRepository customerRepository;
    // private RabbitTemplate rabbitTemplate;
    // private FanoutExchange fanout;

    @Autowired
    public SubscriptionService(JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface,
            SubscriptionRepository subscriptionRepository, ApplicationRepository applicationRepository, CustomerRepository customerRepository
            ) {

        this.jpaSubscriptionRepositoryInterface = jpaSubscriptionRepositoryInterface;
        this.subscriptionRepository = subscriptionRepository;
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
     }

   

    public SubscriptionModel createSubscription(long customerCode, long appCode) {
        CustomerModel customer = customerRepository.findById(customerCode);
        if (customer == null) {
                     throw new IllegalArgumentException("Customer not found with ID: " +
                             customerCode);
                 }

        ApplicationModel app = applicationRepository.findByCode(appCode);
        if (app == null) {
                     throw new IllegalArgumentException("Application not found with ID: " +
                             appCode);
                 }
        
        long id = subscriptionRepository.findLastSubscriptionCode() != null ? 
                subscriptionRepository.findLastSubscriptionCode() + 1 : 1;

        return new SubscriptionModel(id, app, customer, new Date(), new Date());
        }
    }

