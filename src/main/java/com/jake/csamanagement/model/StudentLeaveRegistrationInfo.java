package com.jake.csamanagement.model;

import java.util.Date;

public class StudentLeaveRegistrationInfo {
    private String studentName;
    private String studentNumber;
    private String className;
    private String buildNumber;
    private String roomNumner;
    private String bedNumber;
    private Date outTime;
    private String leaveTheReason;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getRoomNumner() {
        return roomNumner;
    }

    public void setRoomNumner(String roomNumner) {
        this.roomNumner = roomNumner;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getLeaveTheReason() {
        return leaveTheReason;
    }

    public void setLeaveTheReason(String leaveTheReason) {
        this.leaveTheReason = leaveTheReason;
    }
}
