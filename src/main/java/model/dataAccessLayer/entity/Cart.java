/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataAccessLayer.entity;

/**
 *
 * @author Eman-PC
 */
public class Cart {

    private Long recID;
    private Long userID;
    private float totalSum;

    public Cart() {
    }

    public Cart(Long recID, Long userID, float totalSum) {
        this.recID = recID;
        this.userID = userID;
        this.totalSum = totalSum;
    }

    public Long getRecID() {
        return recID;
    }

    public void setRecID(Long recID) {
        this.recID = recID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(float totalSum) {
        this.totalSum = totalSum;
    }
}
