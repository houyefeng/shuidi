/**
 * Created by houyefeng on 2015/8/5.
 */
package com.shuidi.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shuidi.R;
import com.shuidi.dal.entity.CustomerOrder;
import com.shuidi.dal.entity.Order;
import com.shuidi.dal.entity.Product;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        if (null == productList) {
            return 0;
        }
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        if (null == productList) {
            return null;
        }
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProductViewHolder holder = null;
        if (null == convertView) {
            holder = new ProductViewHolder();
            convertView = LayoutInflater.from(this.context).inflate(R.layout.activity_product, null, false);

            holder.setProductName((TextView) convertView.findViewById(R.id.productName));
            holder.setAmount((TextView) convertView.findViewById(R.id.productAmount));
            holder.setTotalMoney((TextView) convertView.findViewById(R.id.totalMoney));

            convertView.setTag(holder);
        } else {
            holder = (ProductViewHolder) convertView.getTag();
        }
        if (null != productList && !productList.isEmpty()) {
            Log.v("debug", "ProductAdapter productList.size=" + productList.size());
            Product product = (Product) getItem(position);
            holder.getProductName().setText(product.getName());
            holder.getAmount().setText(String.valueOf(product.getAmount()));
            holder.getTotalMoney().setText(String.valueOf(product.getAmount() * product.getPrice()));
        }
        return convertView;
    }
}
