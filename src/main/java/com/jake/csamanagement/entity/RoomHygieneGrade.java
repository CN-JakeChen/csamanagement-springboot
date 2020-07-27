package com.jake.csamanagement.entity;


public class RoomHygieneGrade {
 private int roomId;
 private float roomHygieneGrade;
 private String notes;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public float getRoomHygieneGrade() {
        return roomHygieneGrade;
    }

    public void setRoomHygieneGrade(float roomHygieneGrade) {
        this.roomHygieneGrade = roomHygieneGrade;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
