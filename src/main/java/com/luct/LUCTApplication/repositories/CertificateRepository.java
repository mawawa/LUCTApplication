package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.UploadCertificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<UploadCertificate, Long> {
}
