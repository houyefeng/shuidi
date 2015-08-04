package com.shuidi;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.shuidi.adapter.GridListAdapter;
import com.shuidi.dal.DBHelper;
import com.shuidi.dal.InitTestDB;
import com.shuidi.dal.entity.CustomerOrder;
import com.shuidi.dal.entity.Order;
import com.shuidi.service.OrderService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private OrderService orderService;
    private ListView ordersView;
    private GridView orderGridView;
    private GridListAdapter gridListAdapter;

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
        setContentView(R.layout.grid_main);
        //sqlite
        DBHelper dbHelper = new DBHelper(this.getApplicationContext());
        orderService = new OrderService(dbHelper.getWritableDatabase());

        //grid view
        //orderGridView = (GridView)this.findViewById(R.id.orderGridView);
        ordersView = (ListView) this.findViewById(R.id.orderListView);
        gridListAdapter = new GridListAdapter(new ArrayList<CustomerOrder>(), MainActivity.this);
        ordersView.setAdapter(gridListAdapter);
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

    public void showOrders() {
        List<Order> orders = orderService.findOrders(0, 20);

        ArrayList<HashMap<String, Object>> datas = new ArrayList<HashMap<String, Object>>();
        for (Order order : orders) {
            HashMap<String, Object> item = new HashMap<String, Object>();

            item.put("pid", order.getProduct().getId());
            item.put("amount", order.getAmount());
            item.put("status", order.getStatus());

            datas.add(item);
        }
        //创建SimpleAdapter适配器将数据绑定到item显示控件上  
        SimpleAdapter adapter = new SimpleAdapter(this, datas, R.layout.item,
                new String[]{"pid", "amount", "status"}, new int[]{R.id.pid, R.id.amount, R.id.status});
        //实现列表的显示  
        ordersView.setAdapter(adapter);
    }
}
