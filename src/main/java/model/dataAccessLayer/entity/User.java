/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Eman-PC
 */
public class User {

    private Long recID;
    private String name;
    private String password;
    private String email;
    private String address;
    private String job;
    private Date birthdate;
    private float creditLimit;
    private ArrayList<String> interest;

    public User() {
    }

    public User(String email, String name, String password, Date birthdate, String job, float creditLimit, String address, Long recID, ArrayList<String> interest) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.birthdate = birthdate;
        this.job = job;
        this.creditLimit = creditLimit;
        this.address = address;
        this.recID = recID;
        this.interest = interest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public float getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(float creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getRecID() {
        return recID;
    }

    public void setRecID(Long recID) {
        this.recID = recID;
    }

    public ArrayList<String> getInterest() {
        return interest;
    }

    public void setInterest(ArrayList<String> interest) {
        this.interest = interest;
    }
}
