package com.luct.LUCTApplication;

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

}
