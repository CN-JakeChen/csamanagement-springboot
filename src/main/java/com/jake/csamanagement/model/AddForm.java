package com.jake.csamanagement.model;

import java.util.List;

public class AddForm {
    private int id;
    private String username;
    private String password;
    private int role;
    private int dept;
    private List<Integer> manfield;

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

    public int getDept() {
        return dept;
    }

    public void setDept(int dept) {
        this.dept = dept;
    }

    public List<Integer> getManfield() {
        return manfield;
    }

    public void setManfield(List<Integer> manfield) {
        this.manfield = manfield;
    }
}
