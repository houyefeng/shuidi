package com.shuidi.dal.entity;

import java.io.Serializable;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 5432584303286884526L;
    private int id;
    private Product product;
    private String status;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
