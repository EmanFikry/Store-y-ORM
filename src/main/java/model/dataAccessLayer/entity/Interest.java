/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.entity;

/**
 *
 * @author Ghada
 */
public class Interest {
    private Long recID;
    private String name; 
    private Long userID;

    public Long getRecID() {
        return recID;
    }

    public void setRecID(Long recID) {
        this.recID = recID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
    
}
