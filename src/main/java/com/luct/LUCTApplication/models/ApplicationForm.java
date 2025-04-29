package com.luct.LUCTApplication.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class ApplicationForm {
    @SequenceGenerator(name = "luct_application_form", sequenceName = "luct_application_form", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_form")
    @Id
    private Long formId;
    String FullName;
    String IdPassportNum;
    String dateOfBirth;
    String placeOfBirth;
    String gender;
    String nationality;
    String currentHomeAddress
            ,permanentHomeAddress
            ,emailAddress
            ,phoneNumber
            ,guardianFullName
            ,relationShip
            ,occupation
            ,guardianPhoneNumber
            ,programName
            ,startDate
            ,highestQualification
            ,institutionName;
    @OneToMany
    private List<HighSchoolSubject> subjectList;
    boolean disability;
    String disabilityDetails;
    private boolean declaration;

    @ManyToOne
    private LUCTUser potentialStudent;

    public ApplicationForm(Long formId, String fullName, String idPassportNum, String dateOfBirth, String placeOfBirth, String gender, String nationality, String currentHomeAddress, String permanentHomeAddress, String emailAddress, String phoneNumber, String guardianFullName, String relationShip, String occupation, String guardianPhoneNumber, String programName, String startDate, String highestQualification, String institutionName, List<HighSchoolSubject> subjectList, boolean disability, String disabilityDetails, boolean declaration) {
        this.formId = formId;
        FullName = fullName;
        IdPassportNum = idPassportNum;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.currentHomeAddress = currentHomeAddress;
        this.permanentHomeAddress = permanentHomeAddress;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.guardianFullName = guardianFullName;
        this.relationShip = relationShip;
        this.occupation = occupation;
        this.guardianPhoneNumber = guardianPhoneNumber;
        this.programName = programName;
        this.startDate = startDate;
        this.highestQualification = highestQualification;
        this.institutionName = institutionName;
        this.subjectList = subjectList;
        this.disability = disability;
        this.disabilityDetails = disabilityDetails;
        this.declaration = declaration;
    }

    public ApplicationForm() {
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getIdPassportNum() {
        return IdPassportNum;
    }

    public void setIdPassportNum(String idPassportNum) {
        IdPassportNum = idPassportNum;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCurrentHomeAddress() {
        return currentHomeAddress;
    }

    public void setCurrentHomeAddress(String currentHomeAddress) {
        this.currentHomeAddress = currentHomeAddress;
    }

    public String getPermanentHomeAddress() {
        return permanentHomeAddress;
    }

    public void setPermanentHomeAddress(String permanentHomeAddress) {
        this.permanentHomeAddress = permanentHomeAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGuardianFullName() {
        return guardianFullName;
    }

    public void setGuardianFullName(String guardianFullName) {
        this.guardianFullName = guardianFullName;
    }

    public String getRelationShip() {
        return relationShip;
    }

    public void setRelationShip(String relationShip) {
        this.relationShip = relationShip;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getGuardianPhoneNumber() {
        return guardianPhoneNumber;
    }

    public void setGuardianPhoneNumber(String guardianPhoneNumber) {
        this.guardianPhoneNumber = guardianPhoneNumber;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public List<HighSchoolSubject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<HighSchoolSubject> subjectList) {
        this.subjectList = subjectList;
    }

    public boolean isDisability() {
        return disability;
    }

    public void setDisability(boolean disability) {
        this.disability = disability;
    }

    public String getDisabilityDetails() {
        return disabilityDetails;
    }

    public void setDisabilityDetails(String disabilityDetails) {
        this.disabilityDetails = disabilityDetails;
    }

    public boolean isDeclaration() {
        return declaration;
    }

    public void setDeclaration(boolean declaration) {
        this.declaration = declaration;
    }
}
