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
public class Product {
    
    private int product_id;
    private float price;
    private int quantity;
    private String name;
    private String description;
    private String category;
    private String pic_url;

    public Product() {
    }

    public Product(int product_id, float price, int quantity, String name, String description, String category, String pic_url) {
        this.product_id = product_id;
        this.price = price;
        this.quantity = quantity;
        this.name = name;
        this.description = description;
        this.category = category;
        this.pic_url = pic_url;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
    
}
