package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.ApplicationForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationFormRepository extends JpaRepository<ApplicationForm, Long> {
}
