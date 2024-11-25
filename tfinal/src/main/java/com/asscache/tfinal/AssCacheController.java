package com.asscache.tfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.time.LocalDate;

import jakarta.validation.Valid;

@RestController
public class AssCacheController{

    private final AssinaturaRepository assinaturaRepository;

    @Autowired
    public AssCacheController(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }
    
    @GetMapping("")
    public String WelcomeMsg(){
        return ("Hello World");
    }

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<?> getSubscription(@PathVariable Long subscriptionId){
        Assinatura assinatura = assinaturaRepository.findByCode(subscriptionId);
        if (assinatura != null) {
            return ResponseEntity.ok(assinatura);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }

    @GetMapping("/subscriptionvalid/{subscriptionId}")
    public ResponseEntity<?> isSubscriptionvalid(@PathVariable Long subscriptionId) {
        Assinatura assinatura = assinaturaRepository.findByCode(subscriptionId);
        if (assinatura != null) {
            if (assinatura.getBegin_contract_period().before(new LocalDate()) && assinatura.getEnd_contract_period().after(new LocalDate())) {
                return ResponseEntity.ok(true);
            } else {
                return ResponseEntity.ok(false);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
    
    @PostMapping("/renew/subscription")
    public ResponseEntity<?> renewSubscription(@Valid @RequestBody Assinatura assinatura){
        return assinatura;
    }
}