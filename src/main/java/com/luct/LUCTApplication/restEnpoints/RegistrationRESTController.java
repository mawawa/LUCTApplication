package com.luct.LUCTApplication.restEnpoints;

import com.luct.LUCTApplication.models.ApplicationForm;
import com.luct.LUCTApplication.models.LUCTUser;
import com.luct.LUCTApplication.repositories.ApplicationFormRepository;
import com.luct.LUCTApplication.repositories.LUCTUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationRESTController {

    @Autowired
    LUCTUsersRepository luctUsersRepository;
    @Autowired
    ApplicationFormRepository applicationFormRepository;

    @PostMapping("/api/luct/register")
    public ResponseEntity<LUCTUser> register(@ModelAttribute LUCTUser newUser) {
        return ResponseEntity.ok(luctUsersRepository.save(newUser));
    }

    @PostMapping("/api/luct/apply")
    public ResponseEntity<String> apply(@ModelAttribute ApplicationForm newApplicationForm) {
        //todo validate
        //todo algoritym
        applicationFormRepository.save(newApplicationForm);
        return ResponseEntity.ok("Thank you for applying");
    }
}
