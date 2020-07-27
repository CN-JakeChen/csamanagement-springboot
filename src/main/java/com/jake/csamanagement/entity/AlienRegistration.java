package com.jake.csamanagement.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlienRegistration {
    private int id;
    private String name;
    private String phone;
    private String personId;
    private Date entryDate;
    private Date outDate;
    private String visitTheReason;
    private String visitBuild;

    public String getVisitBuild() {
        return visitBuild;
    }

    public void setVisitBuild(String visitBuild) {
        this.visitBuild = visitBuild;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getVisitTheReason() {
        return visitTheReason;
    }

    public void setVisitTheReason(String visitTheReason) {
        this.visitTheReason = visitTheReason;
    }
}
