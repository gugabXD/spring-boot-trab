package com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces;

import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.adapterInterface.repositories.entities.App;
import com.projarq.trabfinal.adapterInterface.repositories.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaSubscriptionRepositoryInterface extends JpaRepository<Subscription, Long> {    

    Subscription findByCode(long code);
    List<Subscription> findByCustomerCode(long code);
    List<Subscription> findByCustomer(Customer customer);    
    List<Subscription> findByAppCode(Long code);
    List<Subscription> findByApp(App application);


    @Query("SELECT MAX(s.code) FROM Subscription s")
    Long findLastSubscriptionCode();

    @Query("SELECT s FROM Subscription s WHERE s.begin_contract_period < CURRENT_DATE AND s.end_contract_period > CURRENT_DATE")
    List<Subscription> findActiveSubscriptions();

    @Query("SELECT s FROM Subscription s WHERE s.begin_contract_period >= CURRENT_DATE OR s.end_contract_period <= CURRENT_DATE")
    List<Subscription> findInactiveSubscriptions();


    Subscription save(Subscription subscription);

}