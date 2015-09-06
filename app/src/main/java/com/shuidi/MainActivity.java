package com.shuidi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.shuidi.adapter.CustomerOrderAdapter;
import com.shuidi.dal.entity.Customer;
import com.shuidi.dal.entity.CustomerOrder;
import com.shuidi.dal.entity.Order;
import com.shuidi.dal.entity.Product;
import com.shuidi.service.OrderService;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private OrderService orderService;
    private ListView customerOrderListView;
    private GridView orderGridView;
    private CustomerOrderAdapter customerOrderAdapter;
    private List<CustomerOrder> customerOrderList;

    /*    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            //sqlite
            DBHelper dbHelper = new DBHelper(this.getApplicationContext());
            new InitTestDB(dbHelper.getWritableDatabase());

            orderService = new OrderService(dbHelper.getWritableDatabase());

            ordersView = (ListView) this.findViewById(R.id.listView);
            showOrders();
        }*/

    /**
     * list-view，grid-view，list-view
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_manage);

        Log.v("debug", "main activity create");
        //grid view
        //orderGridView = (GridView)this.findViewById(R.id.orderGridView);
        customerOrderListView = (ListView) this.findViewById(R.id.customerOrderListView);
        initCustomerOrders();
        customerOrderAdapter = new CustomerOrderAdapter(customerOrderList, MainActivity.this);
        customerOrderListView.setAdapter(customerOrderAdapter);
    }
    private void initCustomerOrders() {
        customerOrderList = new ArrayList<CustomerOrder>(1);
        CustomerOrder co = new CustomerOrder();
        Customer c = new Customer();
        c.setId(1);
        c.setAddress("xxxx");
        c.setName("hyf1");
        c.setPhone("13100000000");
        co.setCustomer(c);

        Order o = new Order();
        o.setId(1);
        o.setAmount(1);
        o.setStatus("0");
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("哇哈哈纯净水");
        p1.setPrice(16f);
        List<Product> productList = new ArrayList<Product>();
        productList.add(p1);
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("哇哈哈矿泉水");
        p2.setPrice(16f);
        productList.add(p2);
        o.setProductList(productList);
        co.setOrder(o);
        customerOrderList.add(co);

        co = new CustomerOrder();
        c = new Customer();
        c.setId(2);
        c.setAddress("纳担保小区17-5-1403");
        c.setName("hyf2");
        c.setPhone("13100000000");
        co.setCustomer(c);

        o = new Order();
        o.setId(2);
        o.setAmount(2);
        o.setStatus("0");
        Product p = new Product();
        p.setId(1);
        p.setName("哇哈哈纯净水");
        p.setPrice(16f);
        productList = new ArrayList<Product>();
        productList.add(p);
        o.setProductList(productList);
        co.setOrder(o);
        customerOrderList.add(co);

        co = new CustomerOrder();
        c = new Customer();
        c.setId(2);
        c.setAddress("纳担保小区17-5-1403");
        c.setName("hyf2");
        c.setPhone("13100000000");
        co.setCustomer(c);

        o = new Order();
        o.setId(3);
        o.setAmount(1);
        o.setStatus("0");
        p = new Product();
        p.setId(2);
        p.setName("哇哈哈矿泉水");
        p.setAmount(2);
        p.setPrice(16f);
        productList = new ArrayList<Product>();
        productList.add(p);
        o.setProductList(productList);
        co.setOrder(o);
        customerOrderList.add(co);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
