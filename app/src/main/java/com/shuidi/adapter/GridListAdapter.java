package com.shuidi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.shuidi.R;
import com.shuidi.dal.entity.CustomerOrder;

import java.util.List;

/**
 * Created by houyefeng on 2015/8/2.
 */
public class GridListAdapter extends BaseAdapter {
    private List<CustomerOrder> orderList;
    private Context context;

    public GridListAdapter(List<CustomerOrder> orderList, Context context) {
        this.orderList = orderList;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (orderList == null) {
            return 0;
        } else {
            return orderList.size();
        }

    }

    @Override
    public Object getItem(int position) {
        if (orderList == null) {
            return null;
        } else {
            return orderList.get(position);
        }

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null==convertView) {
            convertView = LayoutInflater.from
                    (this.context).inflate(R.layout.grid_list_item, null, false);
            GridView gridView = (GridView) convertView.findViewById(R.id.orderGridView);
            convertView.setTag(gridView);

        }
        return convertView;
    }
}
