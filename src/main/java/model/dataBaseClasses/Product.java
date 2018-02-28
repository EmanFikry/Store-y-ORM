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
<<<<<<< HEAD
    

    private int id;
    private float price;
    private int Quantity;
    private String name;
    private String description;
    private String category;
    private String url;
=======

    Long id;
    String name;
    float price;
    String category;
    int amount;
    String imgURL;
    String description;
>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed

    public Product() {
    }

<<<<<<< HEAD
    public Product(int id, float price, int Quantity, String name, String description, String category, String url) {
        this.id = id;
        this.price = price;
        this.Quantity = Quantity;
        this.name = name;
        this.description = description;
        this.category = category;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
=======
    public Product(Long id, float price, int amount, String name, String description, String category, String imgURL) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.description = description;
        this.category = category;
        this.amount = amount;
        this.imgURL = imgURL;
    }


   

    public Long getId() {
        return id;
>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

<<<<<<< HEAD
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

=======
>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
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

>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

<<<<<<< HEAD
    public String getCategory() {
        return category;
    }

=======
>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
    public void setCategory(String category) {
        this.category = category;
    }

<<<<<<< HEAD
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
=======
    public void setId(Long id) {
        this.id = id;
    }

    }
    

>>>>>>> 3248d46dda6541e3b1371d32111756ed28f20aed
