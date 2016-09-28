package com.enterprise.wrapup.wrapup;

import java.io.Serializable;

/**
 * Created by admin on 22.09.2016.
 */
public class Product implements Serializable{
    private int productID;
    private String name;
    private String number;
    private Boolean buyed;

    public Boolean getBuyed() {
        return buyed;
    }

    public void setBuyed(Boolean buyed) {
        this.buyed = buyed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
