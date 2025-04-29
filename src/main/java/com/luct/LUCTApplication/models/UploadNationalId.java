package com.luct.LUCTApplication.models;

import jakarta.persistence.*;

@Entity
public class UploadNationalId {
    @SequenceGenerator(name = "luct_application_nationalId", sequenceName = "luct_application_nationalId", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_nationalId")
    @Id
    private Long nationID;
    @Lob
    private String idData;

    @OneToOne
    private ApplicationForm applicationForm;

    public UploadNationalId(Long nationID, String idData, ApplicationForm applicationForm) {
        this.nationID = nationID;
        this.idData = idData;
        this.applicationForm = applicationForm;
    }

    public UploadNationalId() {
    }

    public Long getNationID() {
        return nationID;
    }

    public void setNationID(Long nationID) {
        this.nationID = nationID;
    }

    public String getIdData() {
        return idData;
    }

    public void setIdData(String idData) {
        this.idData = idData;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
