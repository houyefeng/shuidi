/**
 * Created by houyefeng on 2015/8/9.
 */
package com.shuidi.adapter;

import android.widget.TextView;

public class ProductViewHolder {
    private TextView productName;
    private TextView amount;
    private TextView totalMoney;

    public TextView getProductName() {
        return productName;
    }

    public void setProductName(TextView productName) {
        this.productName = productName;
    }

    public TextView getAmount() {
        return amount;
    }

    public void setAmount(TextView amount) {
        this.amount = amount;
    }

    public TextView getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(TextView totalMoney) {
        this.totalMoney = totalMoney;
    }
}
