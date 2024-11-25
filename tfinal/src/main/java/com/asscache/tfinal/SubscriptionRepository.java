package main.java.com.asscache.tfinal;

import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepository extends CrudRepository<Subscription,Long> {
    Subscription findByCode(Long code);
    Subscription save(Subscription subscription);
}
