package com.jake.csamanagement.model;

public class StudentHygieneGradeInfo {
    private String studentRecordId;
    private String bedNumber;
    private String studentNumber;
    private String studentName;
    private String className;
    private float record;

    public String getStudentRecordId() {
        return studentRecordId;
    }

    public void setStudentRecordId(String studentRecordId) {
        this.studentRecordId = studentRecordId;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getRecord() {
        return record;
    }

    public void setRecord(float record) {
        this.record = record;
    }
}
