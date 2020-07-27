package com.jake.csamanagement.entity;

import java.util.Date;

public class StudentLeaveRegistration {
    private int id;
    private String studentNumber;
    private Date outDate;
    private String leaveTheReason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getLeaveTheReason() {
        return leaveTheReason;
    }

    public void setLeaveTheReason(String leaveTheReason) {
        this.leaveTheReason = leaveTheReason;
    }
}
