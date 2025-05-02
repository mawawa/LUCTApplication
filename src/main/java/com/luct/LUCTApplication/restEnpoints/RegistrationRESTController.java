package com.luct.LUCTApplication.restEnpoints;

import com.luct.LUCTApplication.models.*;
import com.luct.LUCTApplication.repositories.*;
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
    @Autowired
    HighSchoolSubjectRepository highSchoolSubjectRepository;
    @Autowired
    NationalIDRepository nationalIDRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    CertificateRepository certificateRepository;

    @PostMapping("/api/luct/register")
    public ResponseEntity<LUCTUser> register(@ModelAttribute LUCTUser newUser) {
        return ResponseEntity.ok(luctUsersRepository.save(newUser));
    }

    @PostMapping("/api/luct/apply")
    public ResponseEntity<String> apply(@ModelAttribute ApplicationForm newApplicationForm) {
        applicationFormRepository.save(newApplicationForm);
        return ResponseEntity.ok("Thank you for applying");
    }

    @PostMapping("/api/luct/add_subject")
    public ResponseEntity<HighSchoolSubject> addSubject(@ModelAttribute HighSchoolSubject highSchoolSubject){
        return ResponseEntity.ok(highSchoolSubjectRepository.save(highSchoolSubject));
    }

    @PostMapping("/api/luct/upload_certificate")
    public ResponseEntity<UploadCertificate> uploadCertificate(@ModelAttribute UploadCertificate uploadCertificate){
        return ResponseEntity.ok(certificateRepository.save(uploadCertificate));
    }

    @PostMapping("/api/luct/upload_photo")
    public ResponseEntity<UploadPhoto> uploadPhoto(@ModelAttribute UploadPhoto uploadPhoto){
        return ResponseEntity.ok(photoRepository.save(uploadPhoto));
    }

    @PostMapping("/api/luct/upload_payment")
    public ResponseEntity<Payment> uploadPayment(@ModelAttribute Payment payment){
        return ResponseEntity.ok(paymentRepository.save(payment));
    }

    @PostMapping("/api/luct/upload_national")
    public ResponseEntity<UploadNationalId> uploadNationalID(@ModelAttribute UploadNationalId uploadNationalId){
        return ResponseEntity.ok(nationalIDRepository.save(uploadNationalId));
    }


}
