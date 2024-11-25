//TODO refatorar tudo
package main.java.com.asscache.tfinal.domain.services;

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
import java.util.List;
import java.util.Calendar;

@Service
public class SubscriptionService {

    private JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface;

    private SubscriptionRepository subscriptionRepository;
    private ApplicationRepository applicationRepository;
    private CustomerRepository customerRepository;

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

        public List<SubscriptionModel> getAppCode(long appId) {
                return this.subscriptionRepository.findByAppCode(appId);
        }

        public List<SubscriptionModel> getCustomerCode(long customerId) {
                return this.subscriptionRepository.findByCustomerCode(customerId);
        }

        public List<SubscriptionModel> findByType(String type) {
                if(type.toUpperCase().equals("TODAS")) {
                        return this.subscriptionRepository.findAll();
                }
                if(type.toUpperCase().equals("ATIVA")) {
                        return this.subscriptionRepository.findActiveSubscriptions();
                } 
                if(type.toUpperCase().equals("CANCELADA")){
                        return this.subscriptionRepository.findInactiveSubscriptions();
                }
                return null;
        }

        public boolean isActive(long code) {
                SubscriptionModel subscription = this.subscriptionRepository.findByCode(code);
                Date today = new Date();
                return subscription.getBeginContractPeriod().before(today) && subscription.getEndContractPeriod().after(today);
        }

    }

