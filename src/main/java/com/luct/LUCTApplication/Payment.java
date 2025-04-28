package com.luct.LUCTApplication;

import jakarta.persistence.*;

@Entity
public class Payment {
    @SequenceGenerator(name = "luct_application_payment", sequenceName = "luct_application_payment", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_payment")
    @Id
    private Long paymentId;
    @Lob
    private String paymentData;

    @OneToOne
    private Payment payment;

    public Payment(Long paymentId, String paymentData, Payment payment) {
        this.paymentId = paymentId;
        this.paymentData = paymentData;
        this.payment = payment;
    }

    public Payment() {
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

