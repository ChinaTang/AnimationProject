package com.di.tang.myapplication.selfview;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * Created by tangdi on 2016/8/29.
 */
public class CustomScrollViewUtilization extends ScrollView {

    private int mHeaderCurTop;
    private int mHeaderCurBottom;

    private int mContentTop;
    private int mContentBottom;

    private float SCROLL_RATIO = 0.25f;

    //顶部图片
    private View HeaderView;

    //顶部图片初始位置
    private Rect HeaderInitRect = new Rect();

    //底部布局
    private View ContentView;

    //底部布局初始化位置
    private Rect ContentInitRect = new Rect();

    //初始点击位置
    private Point point = new Point();

    private boolean mIsMoving;

    public void setHeaderView(View view){
        HeaderView = view;
    }

    public CustomScrollViewUtilization(Context context) {
        super(context);
    }

    public CustomScrollViewUtilization(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollViewUtilization(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate(){
        ContentView = getChildAt(0);
        super.onFinishInflate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
            {
                point.set((int) event.getX(), (int) event.getY());
                HeaderInitRect.set(HeaderView.getLeft(), HeaderView.getTop(),
                        HeaderView.getRight(), HeaderView.getBottom());
                ContentInitRect.set(ContentView.getLeft(), ContentView.getTop(),
                        ContentView.getRight(), ContentView.getBottom());

            }
                break;
            case MotionEvent.ACTION_MOVE:
            {
                int deltaY = (int) event.getY() - point.y;
                deltaY = deltaY > HeaderView.getHeight() ? HeaderView.getHeight() : deltaY;
                if(deltaY > 0 && deltaY >= getScrollY()){
                    float headerMoveHeight = deltaY * 0.5f * SCROLL_RATIO;
                    mHeaderCurTop = (int) (HeaderInitRect.top + headerMoveHeight);
                    mHeaderCurBottom = (int) (HeaderInitRect.bottom + headerMoveHeight);

                    float contentMoveHeight = deltaY * SCROLL_RATIO;
                    mContentTop = (int) (ContentInitRect.top + contentMoveHeight);
                    mContentBottom = (int) (ContentInitRect.bottom + contentMoveHeight);

                    if (mContentTop <= mHeaderCurBottom) {
                        HeaderView.layout(HeaderInitRect.left, mHeaderCurTop, HeaderInitRect.right, mHeaderCurBottom);
                        ContentView.layout(ContentInitRect.left, mContentTop, ContentInitRect.right, mContentBottom);
                        mIsMoving = true;
                    }
                }
            }
                break;
            case MotionEvent.ACTION_UP:
            {
                if(mIsMoving){
                    HeaderView.layout(HeaderInitRect.left, HeaderInitRect.top, HeaderInitRect.right, HeaderInitRect.bottom);
                    TranslateAnimation animation = new TranslateAnimation(0, 0, mHeaderCurTop - HeaderInitRect.top, 0);
                    animation.setDuration(200);
                    HeaderView.setAnimation(animation);

                    ContentView.layout(ContentInitRect.left, ContentInitRect.top, ContentInitRect.right, ContentInitRect.bottom);
                    TranslateAnimation animation1 = new TranslateAnimation(0, 0, mContentTop - ContentInitRect.top, 0);
                    animation1.setDuration(200);
                    ContentView.setAnimation(animation1);
                    mIsMoving = false;
                }
            }
                break;
        }
        return super.onTouchEvent(event);
    }
}
