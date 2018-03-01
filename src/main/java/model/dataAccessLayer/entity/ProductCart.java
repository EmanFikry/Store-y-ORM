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
public class ProductCart {

    private Long recID;
    private Long productID;
    private Long cartID;
    private Long numOfItems;

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

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public Long getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(Long numOfItems) {
        this.numOfItems = numOfItems;
    }
}
