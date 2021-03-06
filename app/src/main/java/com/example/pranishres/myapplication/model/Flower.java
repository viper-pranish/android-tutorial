package com.example.pranishres.myapplication.model;

/**
 * Created by pranishres on 11/9/16.
 * For parsing data from http://services.hanselandpetal.com/feeds/flowers.xml web service
 */

public class Flower {

    private int productId;
    private String category;
    private String name;
    private String instructions;
    private double price;
    private String photo;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
