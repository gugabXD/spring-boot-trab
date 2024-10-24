package com.projarq.trabfinal.adapterInterface.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.projarq.trabfinal.domain.services.ApplicationService;
import com.projarq.trabfinal.domain.services.CustomerService;
import com.projarq.trabfinal.domain.services.PaymentService;
// import com.projarq.trabfinal.domain.services.SubscriptionService;
import com.projarq.trabfinal.domain.services.UserService;

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
    // private final SubscriptionService subscriptionService;
    private final UserService userServices;

    @Autowired
    public Controller(
            ApplicationService applicationService,
            PaymentService paymentService,
            CustomerService customerService,
            // SubscriptionService subscriptionService,
            UserService userServices) {

        this.applicationService = applicationService;
        this.paymentService = paymentService;
        this.customerService = customerService;
        // this.subscriptionService = subscriptionService;
        this.userServices = userServices;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String isAppRunning() {
        return "teste";
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public String getAllClients() {
        return customerService.findAll().toString();
    }

    @GetMapping("/servcad/aplicativos")
    public String getAllApps() {
        return "/servcad/aplicativos";
    }

    @PostMapping("/servcad/assinaturas")
    public String createSubscription(@RequestBody String body) {
        return body;
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    public String updateAppCost(@PathVariable String idAplicativo, @RequestBody Map<String, Double> custo) {
        return "Aplicativo atualizado com sucesso!";
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    public List<Map<String, Object>> getSubscriptionsByType(@PathVariable String tipo) {
        return new ArrayList<>();
    }

    @GetMapping("/servcad/asscli/{codcli}")
    public List<Map<String, Object>> getClientSubscriptions(@PathVariable String codcli) {
        return new ArrayList<>();
    }

    @GetMapping("/servcad/assapp/{codapp}")
    public List<Map<String, Object>> getAppSubscriptions(@PathVariable String codapp) {

        return new ArrayList<>();
    }

    @PostMapping("/registrarpagamento")
    public String registerPayment(@RequestBody Map<String, Object> paymentData) {
        return "Pagamento registrado com sucesso!";
    }

    @GetMapping("/assinvalida/{codass}")
    public boolean isSubscriptionInvalid(@PathVariable String codass) {
        return false;
    }
}
