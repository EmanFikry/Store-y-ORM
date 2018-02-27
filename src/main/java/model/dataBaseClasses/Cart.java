/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dataBaseClasses;

/**
 *
 * @author Ahmed
 */
public class Cart {
    private int cart_id;
    private int total_sum;

    public Cart() {
    }

    public Cart(int cart_id, int total_sum) {
        this.cart_id = cart_id;
        this.total_sum = total_sum;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getTotal_sum() {
        return total_sum;
    }

    public void setTotal_sum(int total_sum) {
        this.total_sum = total_sum;
    }
    

    
}
