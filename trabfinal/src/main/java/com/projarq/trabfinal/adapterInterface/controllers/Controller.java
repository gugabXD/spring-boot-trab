package com.projarq.trabfinal.adapterInterface.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabfinal.domain.services.ApplicationService;
import com.projarq.trabfinal.domain.services.CustomerService;
import com.projarq.trabfinal.domain.services.PaymentService;
import com.projarq.trabfinal.domain.services.SubscriptionService;
import com.projarq.trabfinal.domain.services.UserService;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
// import com.projarq.trabfinal.application.dtos.SubscriptionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

@RestController
public class Controller {

    private final ApplicationService applicationService;
    private final PaymentService paymentService;
    private final CustomerService customerService;
    private final SubscriptionService subscriptionService;
    private final UserService userServices;

    
    @Autowired
    public Controller(
            ApplicationService applicationService,
            PaymentService paymentService,
            CustomerService customerService,
            SubscriptionService subscriptionService,
            UserService userServices) {

        this.applicationService = applicationService;
        this.paymentService = paymentService;
        this.customerService = customerService;
        this.subscriptionService = subscriptionService;
        this.userServices = userServices;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String isAppRunning() {
        return "Bem-vindo!";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public String getAllClients() {
        return customerService.findAll().toString();
    }

    @GetMapping("/servcad/aplicativos")
    public String getAllApps() {
        return applicationService.findAll().toString();
    }

    @PostMapping("/servcad/assinaturas")
    public String createSubscription(@RequestBody SubscriptionRequest subscription) {
        long customerCode = subscription.getCustomerCode();
        long appCode = subscription.getApplicationCode();
        return subscriptionService.createSubscription(customerCode, appCode).toString();
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idApp}")
    public String updateAppCost(@PathVariable long idApp, @RequestBody Map<String, Double> cost) {
        return applicationService.updateMonthlyCost(idApp, cost.get("cost")).toString();
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<SubscriptionModel> getSubscriptionsByType(@PathVariable String type) {
        return subscriptionService.findByType(type);
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public List<SubscriptionModel> getClientSubscriptions(@PathVariable long codcli) {
        return this.subscriptionService.getCustomerCode(codcli);
    }

    @GetMapping("/servcad/assapp/{codapp}")
    public List<SubscriptionModel> getAppSubscriptions(@PathVariable long codapp) {
        return this.subscriptionService.getAppCode(codapp);
    }

    @PostMapping("/registrarpagamento")
    public String registerPayment(@RequestBody Map<String, Object> paymentData) {
        return "Pagamento registrado com sucesso!";
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean isSubscriptionInvalid(@PathVariable long codass) {
        return this.subscriptionService.isActive(codass);
    }

    public static class SubscriptionRequest {
        private long customerCode;
        private long applicationCode;

        public SubscriptionRequest(long customerCode, long applicationCode) {
            this.customerCode = customerCode;
            this.applicationCode = applicationCode;
        }

        public long getCustomerCode() {
            return customerCode;
        }

        public long getApplicationCode() {
            return applicationCode;
        }
    }
}
