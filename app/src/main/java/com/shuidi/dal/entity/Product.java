package com.shuidi.dal.entity;

import java.io.Serializable;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -8153750508729722729L;
    private int id;
    private String name;
    private float price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
