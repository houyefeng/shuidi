package com.shuidi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.shuidi.R;
import com.shuidi.dal.entity.CustomerOrder;
import com.shuidi.dal.entity.Product;
import com.shuidi.view.ProductGridView;

import java.util.List;

/**
 * Created by houyefeng on 2015/8/2.
 */
public class CustomerOrderAdapter extends BaseAdapter {
    private List<CustomerOrder> customerOrderList;
    private Context context;

    public CustomerOrderAdapter(List<CustomerOrder> customerOrderList, Context context) {
        this.customerOrderList = customerOrderList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (null == customerOrderList) {
            return 0;
        }
        return customerOrderList.size();

    }

    @Override
    public Object getItem(int position) {
        if (null == customerOrderList) {
            return null;
        }
        return customerOrderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("debug", "customer order adapter getView");
        CustomerOrderViewHolder holder = null;
        if (null == convertView) {
            holder = new CustomerOrderViewHolder();
            convertView = LayoutInflater.from
                    (this.context).inflate(R.layout.activity_customer_order, null, false);
            //订单信息的TextView
            holder.setOrderId((TextView) convertView.findViewById(R.id.orderId));
            holder.setOrderInfo((TextView) convertView.findViewById(R.id.orderInfo));
            //订单中商品的GridView
            holder.setProductView((ProductGridView) convertView.findViewById(R.id.productGridView));

            convertView.setTag(holder);

        } else {
            holder = (CustomerOrderViewHolder) convertView.getTag();
        }

        if (null != customerOrderList && !customerOrderList.isEmpty()) {
            CustomerOrder co = (CustomerOrder) getItem(position);
            if (null != holder.getOrderInfo() && null != holder.getOrderId()) {
                holder.getOrderId().setText(String.valueOf(co.getOrder().getId()));
                holder.getOrderInfo().setText(co.getCustomer().getAddress());
            }
            ProductGridView productGridView = holder.getProductView();
            List<Product> productList = co.getOrder().getProductList();
            Log.v("debug", "productList.size=" + productList.size());
            if (null != productGridView && null != productList && !productList.isEmpty()) {
                ProductAdapter productAdapter = new ProductAdapter(context, productList);
                productGridView.setAdapter(productAdapter);
            }
        }
        return convertView;
    }
}
