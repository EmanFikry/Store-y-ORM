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
public class Product {

    private Long recID;
    private String name;
    private float price;
    private String category;
    private int amount;
    private String imgURL;
    private String description;

    public Product() {
    }

    public Product(Long recID, float price, int amount, String name, String description, String category, String imgURL) {
        this.recID = recID;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.imgURL = imgURL;
    }

    public Long getRecID() {
        return recID;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setRecID(Long recID) {
        this.recID = recID;
    }

}
