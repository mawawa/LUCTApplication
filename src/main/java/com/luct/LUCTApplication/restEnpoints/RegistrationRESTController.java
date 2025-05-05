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
    @PostMapping("/api/luct/registry/register")
    public ResponseEntity<LUCTUser> studentRegister(@ModelAttribute ApplicationForm regApplicationForm){
        return ResponseEntity.ok(applicationFormRepository.save(regApplicationForm).getPotentialStudent());
    }

    @PostMapping("/api/luct/apply")
    public ResponseEntity<String> apply(@ModelAttribute ApplicationForm newApplicationForm) {
        newApplicationForm.setScore(0);
        newApplicationForm.setCredits(0);
        newApplicationForm.setQualify(false);
        newApplicationForm.setStatus("Applying");
        ApplicationForm applicationForm =  applicationFormRepository.save(newApplicationForm);

        for (HighSchoolSubject subject : newApplicationForm.getSubjectList()) {
            if (subject.getSymbol().equalsIgnoreCase("A") ||
                    subject.getSymbol().equalsIgnoreCase("B") ||
                    subject.getSymbol().equalsIgnoreCase("C")
            ) {
                applicationForm.setCredits(newApplicationForm.getCredits()+1);
            }
        }

        switch (applicationForm.getProgramName()) {
            case "Associate Degree in Graphic Design", "Associate Degree in Creative Multimedia":
                for (HighSchoolSubject subject : newApplicationForm.getSubjectList()) {

                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (subject.getName().equalsIgnoreCase("English") ||
                                subject.getName().equalsIgnoreCase("Art") ||
                                subject.getName().equalsIgnoreCase("Technical Drawing") ||
                                subject.getName().equalsIgnoreCase("Design & Technology")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());
                        }
                    }
                }
                applicationForm.setQualify(true);

                break;
            case "Associate Degree in Architecture Technology":
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (subject.getName().equalsIgnoreCase("English") ||
                                subject.getName().equalsIgnoreCase("Mathematics") ||
                                subject.getName().equalsIgnoreCase("Technical Drawing") ||
                                subject.getName().equalsIgnoreCase("Design & Technology") ||
                                subject.getName().equalsIgnoreCase("Physical Science")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());
                        }
                    }
                }
                applicationForm.setQualify(true);
                break;
            case "Associate Degree in Public Relations", "Associate Degree in Journalism & Media":
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (subject.getName().equalsIgnoreCase("English") ||
                                subject.getName().equalsIgnoreCase("English Literature")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());

                        }
                    }
                }
                applicationForm.setQualify(true);
                break;
            case "Associate Degree in TV & Film":
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (subject.getName().equalsIgnoreCase("English")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());
                        }
                    }
                }
                applicationForm.setQualify(true);
                break;
            case "Associate Degree in Event Management":
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (
                                subject.getName().equalsIgnoreCase("English") ||
                                        subject.getName().equalsIgnoreCase("Mathematics")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());
                        }
                    }
                }
                applicationForm.setQualify(true);
                break;
            case "Associate Degree in Business Management":
                boolean mathematics = false, english = false, businessStudies = false, accounts = false, economics = false;
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    switch (subject.getName()){
                        case "English":
                            english = true;
                        case "Mathematics":
                            mathematics = true;
                        case "Business Studies":
                            businessStudies = true;
                        case "Accounts":
                            accounts = true;
                        case "Economics":
                            economics = true;
                    }
                    if(mathematics & english & (businessStudies || accounts || economics))
                        applicationForm.setQualify(true);
                    if (subject.getSymbol().equalsIgnoreCase("A") ||
                            subject.getSymbol().equalsIgnoreCase("B") ||
                            subject.getSymbol().equalsIgnoreCase("C")
                    ) {
                        if (subject.getName().equalsIgnoreCase("English") ||
                                subject.getName().equalsIgnoreCase("Mathematics") ||
                                subject.getName().equalsIgnoreCase("Business Studies") ||
                                subject.getName().equalsIgnoreCase("Accounts") ||
                                subject.getName().equalsIgnoreCase("Economic")
                        ) {
                            applicationForm.setScore(newApplicationForm.getScore());
                        }
                    }
                }
            case "Associate Degree in Hotel Management":
                boolean foodAndNutrition = false, homeEconomics = false;
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    switch (subject.getName()) {
                        case "Food & Nutrition":
                            foodAndNutrition = true;
                        case "Home Economics":
                            homeEconomics = true;
                    }
                    if (foodAndNutrition || homeEconomics) {
                        applicationForm.setQualify(true);
                        if (subject.getSymbol().equalsIgnoreCase("A") ||
                                subject.getSymbol().equalsIgnoreCase("B") ||
                                subject.getSymbol().equalsIgnoreCase("C")
                        ) {
                            if (subject.getName().equalsIgnoreCase("English") ||
                                    subject.getName().equalsIgnoreCase("Mathematics") ||
                                    subject.getName().equalsIgnoreCase("Business Studies") ||
                                    subject.getName().equalsIgnoreCase("Accounts") ||
                                    subject.getName().equalsIgnoreCase("Economic")
                            ) {
                                applicationForm.setScore(newApplicationForm.getScore());
                            }
                        }
                    }
                }

            case "Associate Degree in International Tourism":
                boolean englishTo = false, geography = false, tourism = false;
                for (HighSchoolSubject subject : applicationForm.getSubjectList()) {
                    switch (subject.getName()) {
                        case "Geography":
                            geography = true;
                        case "Tourism":
                            tourism = true;
                        case "English":
                            englishTo = true;
                    }
                    if ( englishTo & (geography|| tourism) ) {
                        applicationForm.setQualify(true);
                        if (subject.getSymbol().equalsIgnoreCase("A") ||
                                subject.getSymbol().equalsIgnoreCase("B") ||
                                subject.getSymbol().equalsIgnoreCase("C")
                        ) {
                            if (subject.getName().equalsIgnoreCase("English") ||
                                    subject.getName().equalsIgnoreCase("Geography") ||
                                    subject.getName().equalsIgnoreCase("Tourism")
                            ) {
                                applicationForm.setScore(newApplicationForm.getScore());
                            }
                        }
                    }
                }
            case "Associate Degree in Information Technology":

            case "Associate Degree in Information Technology(PART TIME)":
            case "Associate Degree in Business Information Technology":
            case "Associate Degree in Music Design":



        }
        return ResponseEntity.ok("Thank you for applying");
    }

    @PostMapping("/api/luct/add_subject")
    public ResponseEntity<HighSchoolSubject> addSubject(@ModelAttribute HighSchoolSubject highSchoolSubject) {
        return ResponseEntity.ok(highSchoolSubjectRepository.save(highSchoolSubject));
    }

    @PostMapping("/api/luct/upload_certificate")
    public ResponseEntity<UploadCertificate> uploadCertificate(@ModelAttribute UploadCertificate uploadCertificate) {
        return ResponseEntity.ok(certificateRepository.save(uploadCertificate));
    }

    @PostMapping("/api/luct/upload_photo")
    public ResponseEntity<UploadPhoto> uploadPhoto(@ModelAttribute UploadPhoto uploadPhoto) {
        return ResponseEntity.ok(photoRepository.save(uploadPhoto));
    }

    @PostMapping("/api/luct/upload_payment")
    public ResponseEntity<Payment> uploadPayment(@ModelAttribute Payment payment) {
        return ResponseEntity.ok(paymentRepository.save(payment));
    }

    @PostMapping("/api/luct/upload_national")
    public ResponseEntity<UploadNationalId> uploadNationalID(@ModelAttribute UploadNationalId uploadNationalId) {
        return ResponseEntity.ok(nationalIDRepository.save(uploadNationalId));
    }


}
