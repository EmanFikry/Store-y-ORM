/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBaseClasses;


import java.util.Date;


/**
 *
 * @author Ahmed
 */
public class User {


    private String email;
    private String name;
    private String password;
    private Date birthdate;
    private String job;
    private float creditLimit;
    private String address;
   

    public User() {
    }

    public User(String email, String name, String password, Date birthdate, String job, float creditLimit, String address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.birthdate = birthdate;
        this.job = job;
        this.creditLimit = creditLimit;
        this.address = address;
    
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

    
public String tostString()
{
return "User{" + "email=" + email + ", name=" + name + ", password=" + password + ", birthdate=" + birthdate + ", job=" + job + ", creditLimit=" + creditLimit + ", address=" + address +  '}';
} 

}
