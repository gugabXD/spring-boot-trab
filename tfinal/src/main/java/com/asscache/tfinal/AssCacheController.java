package com.asscache.tfinal;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AssCacheController{
    
    @GetMapping("")
    public String WelcomeMsg(){
        return ("Hello World");
    }

    @GetMapping("/subscription/{subscriptionId}")
    public Subscription getSubscription(@PathVariable Long subscriptionId){
        Subscription subscription = subscriptionRepository.findByCode(subscriptionId);
        return subscription;
    }
    
    @PostMapping("/renew/subscription")
    public boolean renewSubscription(@valid @RequestBody Subscription subscription){
        return subscription;
    }
}