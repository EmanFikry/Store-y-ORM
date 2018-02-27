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

    Long id;
    String name;
    float price;
    String category;
    int amount;
    String imgURL;
    String description;

    public Product() {
    }

    public Product(Long id, float price, int amount, String name, String description, String category, String imgURL) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.name = name;
        this.description = description;
        this.category = category;
        this.imgURL = imgURL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
