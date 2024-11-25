package com.asscache.tfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    public Assinatura getSubscription(@PathVariable Long assinaturaId){
        Assinatura assinatura = assinaturaRepository.findByCode(assinaturaId);
        return assinatura;
    }
    
    @PostMapping("/renew/subscription")
    public boolean renewSubscription(@Valid @RequestBody Assinatura assinatura){
        return assinatura;
    }
}