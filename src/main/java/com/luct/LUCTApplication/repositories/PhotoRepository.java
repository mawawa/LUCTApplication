package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.UploadPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<UploadPhoto, Long> {
}
