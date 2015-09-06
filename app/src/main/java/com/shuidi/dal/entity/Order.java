package com.shuidi.dal.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 5432584303286884526L;
    private int id;
    private List<Product> productList;
    private String status;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
