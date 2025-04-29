package com.luct.LUCTApplication.models;

import jakarta.persistence.*;

@Entity
public class HighSchoolSubject {
    @SequenceGenerator(name = "luct_application_form", sequenceName = "luct_application_form", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "luct_application_form")
    @Id
    private long subjectId;
    private String name;
    private String symbol;

    public HighSchoolSubject(long subjectId, String name, String symbol) {
        this.subjectId = subjectId;
        this.name = name;
        this.symbol = symbol;
    }

    public HighSchoolSubject() {
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
