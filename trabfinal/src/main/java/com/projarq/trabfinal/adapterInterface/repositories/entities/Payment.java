package com.projarq.trabfinal.adapterInterface.repositories.entities;

import com.projarq.trabfinal.domain.entities.PaymentModel;
import com.projarq.trabfinal.domain.entities.SubscriptionModel;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    private Long code;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "subscription_code", referencedColumnName = "code")
    private Subscription subscription_code;
    private Double amount_paid;
    private String sale;

    protected Payment() {
    }

    public Payment(Long code, Subscription subscription_code, Double amount_paid, Date date, String sale) {
        this.code = code;
        this.subscription_code = subscription_code;
        this.amount_paid = amount_paid;
        this.sale = sale;
    }

    public Long getCode() {
        return code;
    }

    public Subscription getSubscription_code() {
        return subscription_code;
    }

    public Double getAmount_paid() {
        return amount_paid;
    }

    public String getSale() {
        return sale;
    }

    public Date getPaymentDate() {
        return date;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setSubscription_code(Subscription subscription_code) {
        this.subscription_code = subscription_code;
    }

    public void setAmount_paid(Double amount_paid) {
        this.amount_paid = amount_paid;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public static PaymentModel toPaymentModel(Payment pagamento) {
        return new PaymentModel(
                pagamento.getCode(),
                Subscription.toSubscriptionModel(pagamento.getSubscription_code()),
                pagamento.getAmount_paid(),
                pagamento.getPaymentDate(),
                pagamento.getSale()

        );
    }

    public static Payment fromPaymentModel(PaymentModel paymentModel) {
        return new Payment(
                paymentModel.getCode(),
                Subscription.fromSubscriptionModel(paymentModel.getSubscription()),
                paymentModel.getAmountPaid(),
                paymentModel.getDate(),
                paymentModel.getSale()
        );
    }

}
