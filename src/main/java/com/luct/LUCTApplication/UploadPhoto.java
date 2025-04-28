package com.luct.LUCTApplication;

import jakarta.persistence.*;

@Entity
public class UploadPhoto {

    @SequenceGenerator(name = "luct_application_photo", sequenceName = "luct_application_photo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_photo")
    @Id
    private Long photoId;
    @Lob
    private String imageData;
    @OneToOne
    private ApplicationForm applicationForm;

    public UploadPhoto(Long photoId, String imageData, ApplicationForm applicationForm) {
        this.photoId = photoId;
        this.imageData = imageData;
        this.applicationForm = applicationForm;
    }

    public UploadPhoto() {
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
