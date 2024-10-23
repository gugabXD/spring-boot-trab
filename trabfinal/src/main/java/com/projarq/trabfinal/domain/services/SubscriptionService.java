package com.projarq.trabfinal.domain.services;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projarq.trabfinal.adapterInterface.repositories.entities.Subscription;

import com.projarq.trabfinal.adapterInterface.repositories.jpaInterfaces.JpaSubscriptionRepositoryInterface;

import java.util.Date;


@Service
public class SubscriptionService {

    private JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface;

    private AssinaturaRepositoryImpl assinaturaRepositoryImpl;
    private AplicativoRepositoryImpl aplicativoRepositoryImpl;
    private ClienteRepositoryImpl clienteRepositoryImpl;
    private RabbitTemplate rabbitTemplate;
    private FanoutExchange fanout;

    @Autowired
    public SubscriptionService (JpaSubscriptionRepositoryInterface jpaSubscriptionRepositoryInterface, 
                                AssinaturaRepositoryImpl assinaturaRepositoryImpl, AplicativoRepositoryImpl aplicativoRepositoryImpl, 
                                ClienteRepositoryImpl clienteRepositoryImpl, RabbitTemplate rabbitTemplate , FanoutExchange fanout){

        this.jpaSubscriptionRepositoryInterface = jpaSubscriptionRepositoryInterface;

        this.assinaturaRepositoryImpl = assinaturaRepositoryImpl;
        this.aplicativoRepositoryImpl = aplicativoRepositoryImpl;
        this.clienteRepositoryImpl = clienteRepositoryImpl;
        this.rabbitTemplate = rabbitTemplate;
        this.fanout = fanout;
    }

        public List<AssinaturaModel> getFromAppId(long appId) {
        return this.assinaturaRepositoryImpl.findByAplicativoId(appId);
    }

    public List<AssinaturaModel> getFromClienteId(long clienteId) {
        return this.assinaturaRepositoryImpl.findByClienteId(clienteId);
    }

    public List<AssinaturaModel> getFromType(AssinaturaEnum type) {
        if (type == AssinaturaEnum.TODAS) {
            return this.assinaturaRepositoryImpl.findAll();
        } else if (type == AssinaturaEnum.ATIVA) {
            return this.assinaturaRepositoryImpl.findActiveAssinaturas();
        } else if (type == AssinaturaEnum.CANCELADA) {
            return this.assinaturaRepositoryImpl.findInactiveAssinaturas();
        }
        return null;
    }

    public AssinaturaModel criaNovaAssinatura(long codCliente, long codAplicativo) {
        ClienteModel cliente = clienteRepositoryImpl.findById(codCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente not found with ID: " + codCliente);
        }

        AplicativoModel aplicativo = aplicativoRepositoryImpl.findById(codAplicativo);

        if (aplicativo == null) {
            throw new IllegalArgumentException("Aplicativo not found with ID: " + codAplicativo);
        }

        long id = assinaturaRepositoryImpl.findLastAssinaturaId() + 1;
        Date now = new Date();

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(now);

        calendar.add(Calendar.MONTH, 1);

        Date nowInAMonth = calendar.getTime();
        AssinaturaModel nova = new AssinaturaModel(id, aplicativo,cliente, now, nowInAMonth);

       return assinaturaRepositoryImpl.save(nova);
    }

    public AssinaturaModel getFromAssinaturaId(long assinaturaId) {
        return this.assinaturaRepositoryImpl.findById(assinaturaId);
    }

    public void saveAssinatura(AssinaturaModel assinatura){
        AssinaturaDTO assinaturaDto = new AssinaturaDTO(assinatura.getFimVigencia(), assinatura.getId());
        rabbitTemplate.convertAndSend(fanout.getName(),"",assinaturaDto);
        this.assinaturaRepositoryImpl.save(assinatura);
    }

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

    public Boolean inTime(long code){
        Subscription subscription = this.jpaSubscriptionRepositoryInterface.findByCode(code);

        if(subscription != null){
            return subscription.getBegin_contract_period().before(new Date()) && subscription.getEnd_contract_period().after(new Date());
        }
        return null;
    }
    
}
