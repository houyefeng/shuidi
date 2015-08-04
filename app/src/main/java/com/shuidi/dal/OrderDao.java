package com.shuidi.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.shuidi.dal.entity.CustomerOrder;

import java.util.List;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class OrderDao {
    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public OrderDao(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public List<CustomerOrder> getCustomerOrders(){
        return null;
    }
}
