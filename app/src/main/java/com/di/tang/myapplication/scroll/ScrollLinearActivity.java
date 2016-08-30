package com.di.tang.myapplication.scroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/30.
 */
public class ScrollLinearActivity extends AppCompatActivity {
    private LinearLayout layout;
    private int mlastX;
    @Override
    protected void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
        setContentView(R.layout.scroll_base);
        layout = (LinearLayout)findViewById(R.id.linear);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int scrollX = layout.getScrollX();
        int x = (int)event.getX();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            int newScrollX = scrollX + mlastX - x;
            layout.scrollBy(newScrollX, 0);
        }
        mlastX = x;
        return super.onTouchEvent(event);
    }
}
