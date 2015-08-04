package com.shuidi.service;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.shuidi.dal.entity.Order;
import com.shuidi.dal.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houyefeng on 2015/7/31.
 */
public class OrderService {
    private SQLiteDatabase db = null;

    public OrderService(SQLiteDatabase db) {
        this.db = db;
    }

    public List<Order> findOrders(int offset, int size) {
        StringBuffer orderSql = new StringBuffer();
        orderSql.append("select customer_id,product_id,status,amount ")
                .append(" from orders ")
                .append(" order by id desc ")
                .append(" limit ").append(size).append(" offset ").append(offset);
        Cursor cursor = db.rawQuery(orderSql.toString(), null);
        if (cursor.moveToFirst()) {
            List<Order> orderList = new ArrayList<Order>(size);
            while (cursor.moveToNext()) {
                Order order = new Order();
                order.setStatus(cursor.getString(2));
                order.setAmount(cursor.getInt(3));

                Product product = new Product();
                product.setId(cursor.getInt(1));
                order.setProduct(product);
                orderList.add(order);
            }
            return orderList;
        }

        return null;
    }
}
