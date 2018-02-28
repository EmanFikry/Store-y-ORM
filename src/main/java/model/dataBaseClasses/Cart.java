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
<<<<<<< HEAD
    private int id;
    private Product product;
    private int quantity;
=======
    private int cart_id;
    private int total_sum;
>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed

    public Cart() {
    }

<<<<<<< HEAD
    public Cart(int id, Product product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
=======
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
    

>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
    
}
