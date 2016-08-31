package com.di.tang.myapplication.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;

/**
 * Created by tangdi on 2016/8/31.
 */
public class ScrollListView extends ListView {

    private LinearLayout linearLayout;

    private ScrollListAdapter.DataHold dataHold;

    private Scroller mScroller;

    //超出部分的总长度，单位dp
    private static int MAXDIP = 200;

    private int mlastx = 0;

    private int dpToPX(Context context, int dip){
        return (int)(dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    public ScrollListView(Context context) {
        super(context);
        mScroller = new Scroller(context, new LinearInterpolator(context, null));
    }

    public ScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context, new LinearInterpolator(context, null));
    }

    public ScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context, new LinearInterpolator(context, null));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int x = (int)event.getX();
        int y = (int)event.getY();
        int maxLength = dpToPX(getContext(), MAXDIP);
        int scrollX;
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN : {
                int postion = pointToPosition(x, y);
                if (postion != INVALID_POSITION) {
                    dataHold =
                            (ScrollListAdapter.DataHold) getItemAtPosition(postion);
                    linearLayout = dataHold.layout;
                }
            }
            case MotionEvent.ACTION_MOVE :
                scrollX = linearLayout.getScrollX();
                int newScrollX = scrollX + (mlastx - x);
                if(newScrollX < 0){
                    newScrollX = 0;
                }else if(newScrollX > maxLength){
                    newScrollX = maxLength;
                }
                linearLayout.scrollTo(newScrollX, 0);
                break;
            case MotionEvent.ACTION_UP :
                scrollX = linearLayout.getScrollX();
                //int newScrollX1 = scrollX + (mlastx - x);
                if(scrollX < maxLength / 2){
                    linearLayout.scrollTo(0, 0);
                    dataHold.isScroll = false;
                    mScroller.startScroll(scrollX, 0, 0 - scrollX, 0);
                    invalidate();
                }else{
                    linearLayout.scrollTo(maxLength, 0);
                    dataHold.isScroll = true;
                    mScroller.startScroll(scrollX, 0, maxLength - scrollX, 0);
                    invalidate();
                }
                break;
        }
        mlastx = x;
        return super.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            linearLayout.scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }
}
