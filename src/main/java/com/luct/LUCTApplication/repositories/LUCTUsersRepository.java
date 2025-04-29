package com.luct.LUCTApplication.repositories;

import com.luct.LUCTApplication.models.LUCTUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LUCTUsersRepository extends JpaRepository<LUCTUser, Long> {
}
