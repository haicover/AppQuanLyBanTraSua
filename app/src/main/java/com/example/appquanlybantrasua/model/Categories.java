package com.example.appquanlybantrasua.model;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {
    private String name;
    private List<Product> productList;

    public Categories(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
