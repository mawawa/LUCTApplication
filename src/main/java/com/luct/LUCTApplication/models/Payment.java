package com.luct.LUCTApplication.models;

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
    private ApplicationForm applicationForm;

    public Payment(Long paymentId, String paymentData, ApplicationForm applicationForm) {
        this.paymentId = paymentId;
        this.paymentData = paymentData;
        this.applicationForm = applicationForm;
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

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}

