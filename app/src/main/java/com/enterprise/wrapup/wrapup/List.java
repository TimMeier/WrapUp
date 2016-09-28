package com.enterprise.wrapup.wrapup;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by admin on 22.09.2016.
 */
public class List implements Serializable {
    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProductToList(Product product){
        this.products.add(product);
    }

    public void replaceList(ArrayList<Product> products){
        this.products = products;
    }
}
