package com.projarq.trabfinal.adapterInterface.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabfinal.domain.services.ApplicationService;
import com.projarq.trabfinal.domain.services.CustomerService;
import com.projarq.trabfinal.domain.services.PaymentService;
import com.projarq.trabfinal.domain.services.SubscriptionService;
import com.projarq.trabfinal.domain.services.UserService;
import com.projarq.trabfinal.domain.entities.ApplicationModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import com.projarq.trabfinal.domain.entities.PaymentModel;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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

    @PostMapping("/servcad/aplicativos/atualizacusto/{cost}")
    public ApplicationModel updateAppCost(@PathVariable long idApp, @RequestBody double cost) {
        return applicationService.updateMonthlyCost(idApp, cost);
    }

    @GetMapping("/servcad/assinaturas/{type}")
    public List<SubscriptionModel> getSubscriptionsByType(@PathVariable String type) {
        return subscriptionService.findByType(type);
    }

    @GetMapping("/servcad/asscli/{customerCode}")
    public List<SubscriptionModel> getClientSubscriptions(@PathVariable long customerCode) {
        return this.subscriptionService.getCustomerCode(customerCode);
    }

    @GetMapping("/servcad/assapp/{appCode}")
    public List<SubscriptionModel> getAppSubscriptions(@PathVariable long appCode) {
        return this.subscriptionService.getAppCode(appCode);
    }

    @PostMapping("/registrarpagamento")
    public ResponseEntity<Response> registerPayment(@RequestBody PaymentRequest paymentData) {
        Response response = new Response();

        String day = paymentData.getDay();
        String month = paymentData.getMonth();
        String year = paymentData.getYear();
        Double paidValue = paymentData.getPaidValue();
        long subsCode = paymentData.getSubsCode();
        
        SubscriptionModel subscription = subscriptionService.getSubscriptionCode(subsCode);
        double monthlyCost = subscription.getApplication().getmonthCost();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        Date date = calendar.getTime();
        String sale = "sale";
            if (paidValue >= monthlyCost) {
            PaymentModel payment = new PaymentModel(subsCode, subscription, paidValue, date, sale);
            response.status = "PAGAMENTO_OK";
            response.reversedValue = 0.0;
            response.date = date;

            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            Date nowInAMonth = calendar.getTime();

            subscription.setEndContractPeriod(nowInAMonth);
            subscriptionService.saveSubscription(subscription);
            paymentService.paymentRegister(payment);
        } 
        
        else 
        {
            response.status = "VALOR_INCORRETO";
            response.reversedValue = monthlyCost - paidValue;
            response.date = date;
        }
        return ResponseEntity.ok(response);
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
    public static class PaymentRequest {
        private String day;
        private String month;
        private String year;
        private Double paidValue;
        private Long subsCode;

        public String getDay() {
            return day;
        }

        public String getMonth() {
            return month;
        }

        public String getYear() {
            return year;
        }

        public Double getPaidValue() {
            return paidValue;
        }

        public Long getSubsCode() {
            return subsCode;
        }
    }
    public static class Response {
        public String status;
        public Date date;
        public double reversedValue;
    }

}
