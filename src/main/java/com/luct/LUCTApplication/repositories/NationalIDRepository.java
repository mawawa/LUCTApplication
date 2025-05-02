package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.UploadNationalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalIDRepository extends JpaRepository<UploadNationalId, Long> {
}
