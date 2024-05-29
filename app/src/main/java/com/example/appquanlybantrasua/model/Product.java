package com.example.appquanlybantrasua.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private double price;
    private String description;

    private int icon;

    public Product(String name, double price, String description,int icon) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.icon=icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
