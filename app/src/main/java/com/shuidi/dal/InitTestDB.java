package com.shuidi.dal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by houyefeng on 2015/7/23.
 */
public class InitTestDB {
    public InitTestDB(SQLiteDatabase db) {
//        initCustomer(db);
//        initProduct(db);
//        initOrder(db);
    }
    private void initOrder(SQLiteDatabase db) {
        StringBuffer sqlSB = new StringBuffer("insert into orders(customer_id,product_id,status,amount)");
        sqlSB.append("select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,0,1 ")
                .append("union all select 1,1,1,1 ")
                .append("union all select 1,1,1,1");
        db.execSQL(sqlSB.toString());
    }
    private void initCustomer(SQLiteDatabase db){
        String sql = "insert into customers (sex,name,phone,address) " +
                "values(0,'hyf',15010152991,'纳丹堡')";
        db.execSQL(sql);
    }
    private void initProduct(SQLiteDatabase db){
        ContentValues product = new ContentValues();
        product.put("name", "wahaha");
        product.put("price",Float.valueOf(20));
        db.insert("products", null, product);
    }
}
