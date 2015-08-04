package com.shuidi.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by houyefeng on 2015/7/15.
 */
public class DBHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "shuidi_test.db";
    private final static int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     * 当数据库版本改变时由系统调用，可在这里对添加新表、修改已有表的结构、删除已有表等操作。
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 数据库第一次创建时由系统调用，可以在这里完成表的创建，数据初始化等操作。
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS customers (id INTEGER PRIMARY KEY AUTOINCREMENT,sex INTEGER DEFAULT 0,name VARCHAR,phone VARCHAR,address VARCHAR," +
                "create_time DATETIME DEFAULT (datetime(CURRENT_TIMESTAMP,'localtime')))");
        db.execSQL("CREATE TABLE IF NOT EXISTS orders (id INTEGER PRIMARY KEY AUTOINCREMENT,customer_id INTEGER DEFAULT 0,product_id INTEGER DEFAULT 0,status INTEGER DEFAULT 0," +
                "amount INTEGER DEFAULT 1,create_time DATETIME DEFAULT (datetime(CURRENT_TIMESTAMP,'localtime')))");
        db.execSQL("CREATE TABLE IF NOT EXISTS products (id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR,price REAL DEFAULT 20," +
                "create_time DATETIME DEFAULT (datetime(CURRENT_TIMESTAMP,'localtime')))");
    }
}
