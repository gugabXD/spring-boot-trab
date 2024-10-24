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
            SubscriptionRepository subscriptionRepository, ApplicationRepository applicationRepository
            // customerRepository customerRepository, RabbitTemplate rabbitTemplate,
            // FanoutExchange fanout
            ) {

        this.jpaSubscriptionRepositoryInterface = jpaSubscriptionRepositoryInterface;

        this.subscriptionRepository = subscriptionRepository;
        this.applicationRepository = applicationRepository;
        this.customerRepository = customerRepository;
    //     this.rabbitTemplate = rabbitTemplate;
    //     this.fanout = fanout;
    // }

    // public List<CustomerModel> getFromAppId(long appId) {
    //     return this.subscriptionRepository.findByAplicativoId(appId);
    // }

    // public List<CustomerModel> getFromClienteId(long clienteId) {
    //     return this.subscriptionRepository.findByClienteId(clienteId);
    // }

    // public List<CustomerModel> getFromType(AssinaturaEnum type) {
    //     if (type == AssinaturaEnum.TODAS) {
    //         return this.subscriptionRepository.findAll();
    //     } else if (type == AssinaturaEnum.ATIVA) {
    //         return this.subscriptionRepository.findActiveAssinaturas();
    //     } else if (type == AssinaturaEnum.CANCELADA) {
    //         return this.subscriptionRepository.findInactiveAssinaturas();
    //     }
    //     return null;
    // }

    // public CustomerModel criaNovaAssinatura(long codCliente, long codAplicativo) {
    //     CustomerModel cliente = customerRepository.findById(codCliente);
    //     if (cliente == null) {
    //         throw new IllegalArgumentException("Cliente not found with ID: " +
    //                 codCliente);
    //     }
    //     return new CustomerModel();
    // }
        // ApplicationModel aplicativo = applicationRepository.findById(codAplicativo);

        // if (aplicativo == null) {
        // throw new IllegalArgumentException("Aplicativo not found with ID: " +
        // codAplicativo);
        // }

        // long id = subscriptionRepository.findLastAssinaturaId() + 1;
        // Date now = new Date();

        // Calendar calendar = Calendar.getInstance();

        // calendar.setTime(now);

        // calendar.add(Calendar.MONTH, 1);

        // Date nowInAMonth = calendar.getTime();
        // CustomerModel nova = new CustomerModel(id, aplicativo, cliente, now,
        // nowInAMonth);

        // return subscriptionRepository.save(nova);
    }

    // public CustomerModel getFromAssinaturaId(long assinaturaId) {
    // return this.subscriptionRepository.findById(assinaturaId);
    // }

    // public void saveAssinatura(CustomerModel assinatura) {
    // AssinaturaDTO assinaturaDto = new AssinaturaDTO(assinatura.getFimVigencia(),
    // assinatura.getId());
    // rabbitTemplate.convertAndSend(fanout.getName(), "", assinaturaDto);
    // this.subscriptionRepository.save(assinatura);
    // }

    public class AssinaturaDTO {
        private Date expirationDate;
        private Long idAssinatura;

        AssinaturaDTO(Date expirationDate, Long idAssinatura) {
            this.expirationDate = expirationDate;
            this.idAssinatura = idAssinatura;
        }

        public Date getExpirationDate() {
            return expirationDate;
        }

        public Long getIdAssinatura() {
            return idAssinatura;
        }
    }

    public Boolean inTime(long code) {
        Subscription subscription = this.jpaSubscriptionRepositoryInterface.findByCode(code);

        if (subscription != null) {
            return subscription.getBegin_contract_period().before(new Date())
                    && subscription.getEnd_contract_period().after(new Date());
        }
        return null;
    }

}
