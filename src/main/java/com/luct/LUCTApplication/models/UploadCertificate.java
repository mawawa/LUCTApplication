package com.luct.LUCTApplication.models;

import jakarta.persistence.*;

@Entity
public class UploadCertificate {
    @SequenceGenerator(name = "luct_application_certificate", sequenceName = "luct_application_certificate", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_certificate")
    @Id
    private Long certificateId;
    @Lob
    private String certificateData;
    @ManyToOne
    private ApplicationForm applicationForm;

    public UploadCertificate(Long certificateId, String certificateData, ApplicationForm applicationForm) {
        this.certificateId = certificateId;
        this.certificateData = certificateData;
        this.applicationForm = applicationForm;
    }

    public UploadCertificate() {
    }

    public Long getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Long certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateData() {
        return certificateData;
    }

    public void setCertificateData(String certificateData) {
        this.certificateData = certificateData;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
