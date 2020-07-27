package com.jake.csamanagement.entity;

import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private int role;
    private int deptId=0;
    private String deptName;
    private List<String> filedList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<String> getFiledList() {
        return filedList;
    }

    public void setFiledList(List<String> filedList) {
        this.filedList = filedList;
    }
}
