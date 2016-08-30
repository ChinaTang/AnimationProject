package com.di.tang.myapplication.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by tangdi on 2016/8/30.
 */
public class SelfScrollLinearLayour extends LinearLayout {

    private int mlastX;

    public SelfScrollLinearLayour(Context context) {
        super(context);
    }

    public SelfScrollLinearLayour(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelfScrollLinearLayour(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int scrollX = this.getScrollX();
        int x = (int)event.getX();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            int newScrollX = scrollX + mlastX - x;
            this.scrollBy(newScrollX, 0);
        }
        mlastX = x;
        return super.onTouchEvent(event);

    }
}
