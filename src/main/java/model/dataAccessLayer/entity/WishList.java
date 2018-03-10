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
public class WishList {

    private Long recID;
    private Long productID;
    private Long userID;
    private Long numOfItem;

    public Long getRecID() {
        return recID;
    }

    public void setRecID(Long recID) {
        this.recID = recID;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getNumOfItem() {
        return numOfItem;
    }

    public void setNumOfItem(Long numOfItem) {
        this.numOfItem = numOfItem;
    }
}
