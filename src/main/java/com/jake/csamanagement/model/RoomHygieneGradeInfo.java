package com.jake.csamanagement.model;

import java.util.Date;
import java.util.List;

public class RoomHygieneGradeInfo {
    private int roomRecordId;
    private int roomId;
    private String buildNumber;
    private String roomNumber;
    private float roomGrade;
    private Date recordTime;
    private List<StudentHygieneGradeInfo> studentHygieneGradeInfoList;

    public int getRoomRecordId() {
        return roomRecordId;
    }

    public void setRoomRecordId(int roomRecordId) {
        this.roomRecordId = roomRecordId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public float getRoomGrade() {
        return roomGrade;
    }

    public void setRoomGrade(float roomGrade) {
        this.roomGrade = roomGrade;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public List<StudentHygieneGradeInfo> getStudentHygieneGradeInfoList() {
        return studentHygieneGradeInfoList;
    }

    public void setStudentHygieneGradeInfoList(List<StudentHygieneGradeInfo> studentHygieneGradeInfoList) {
        this.studentHygieneGradeInfoList = studentHygieneGradeInfoList;
    }
}
