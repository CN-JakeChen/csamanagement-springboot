package com.jake.csamanagement.model;

import java.util.Date;

public class StudentRecordForm {
    private int studentRecordId;
    private float studentHygieneGrade;
    private Date recordTime;
    public int getStudentRecordId() {
        return studentRecordId;
    }

    public void setStudentRecordId(int studentRecordId) {
        this.studentRecordId = studentRecordId;
    }

    public float getStudentHygieneGrade() {
        return studentHygieneGrade;
    }

    public void setStudentHygieneGrade(float studentHygieneGrade) {
        this.studentHygieneGrade = studentHygieneGrade;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}
