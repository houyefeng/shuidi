package com.shuidi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by houyefeng on 2015/8/9.
 */
public class ProductGridView extends GridView {
    public ProductGridView(Context context) {
        super(context);
    }

    public ProductGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProductGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
