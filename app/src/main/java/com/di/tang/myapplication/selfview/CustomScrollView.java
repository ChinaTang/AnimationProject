package com.di.tang.myapplication.selfview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by tangdi on 2016/8/26.
 */
public class CustomScrollView extends ScrollView {

    private View RootView;
    private int mpreY;
    private Rect RootRect;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        RootView = getChildAt(0);
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        int curY = (int)event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE :
                int delate = (int)((curY - mpreY) * 0.25);
                if(delate > 0){
                    RootView.layout(RootView.getLeft(), RootView.getTop() + delate,
                            RootView.getRight(), RootView.getBottom() + delate);
                }
                break;
            case MotionEvent.ACTION_DOWN :
                if(RootView != null){
                    RootRect = new Rect(RootView.getLeft(), RootView.getTop(),
                            RootView.getRight(), RootView.getBottom());
                }
                break;
            case MotionEvent.ACTION_UP :
                int curTop = RootView.getTop();
                RootView.layout( RootRect.left, RootRect.top, RootRect.right, RootRect.bottom);
                TranslateAnimation animation = new TranslateAnimation(0, 0, curTop - RootRect.top, 0);
                animation.setDuration(200);
                RootView.startAnimation(animation);
        }
        mpreY = curY;
        return super.onTouchEvent(event);
    }
}
