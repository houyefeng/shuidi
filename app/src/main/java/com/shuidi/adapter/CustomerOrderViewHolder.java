/**
 * Created by houyefeng on 2015/8/9.
 */
package com.shuidi.adapter;

import android.widget.GridView;
import android.widget.TextView;

import com.shuidi.view.ProductGridView;

public class CustomerOrderViewHolder {
    private TextView orderInfo;
    private TextView orderId;
    private ProductGridView productView;

    public TextView getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(TextView orderInfo) {
        this.orderInfo = orderInfo;
    }

    public TextView getOrderId() {
        return orderId;
    }

    public void setOrderId(TextView orderId) {
        this.orderId = orderId;
    }

    public ProductGridView getProductView() {
        return productView;
    }

    public void setProductView(ProductGridView productView) {
        this.productView = productView;
    }
}
