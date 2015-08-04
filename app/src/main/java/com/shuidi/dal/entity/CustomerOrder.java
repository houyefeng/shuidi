package com.shuidi.dal.entity;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class CustomerOrder {
    private Customer customer;
    private Order order;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
