package com.luct.LUCTApplication;

import jakarta.persistence.*;

@Entity
public class LUCTUser {
    @SequenceGenerator(name = "luct_application_user", sequenceName = "luct_application_user", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_user")
    @Id
    private Long userId;
    private String emailAddress;
    private String password;
    @Transient
    private String confirmPassword;
    private String role;
    private String fullName;

    public LUCTUser(String userId, String emailAddress, String password, String confirmPassword, String role, String fullName) {
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LUCTUser() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
