package com.di.tang.myapplication.scroll;

import android.content.Context;
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
    private static final int MAXSIZE = 200;
    @Override
    protected void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
        setContentView(R.layout.scroll_base);
        layout = (LinearLayout)findViewById(R.id.linear);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int maxLength = dipToPX(this, MAXSIZE);
        int scrollX = layout.getScrollX();
        int x = (int)event.getX();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            int newScrollX = scrollX + mlastX - x;
            if(newScrollX < 0){
                newScrollX = 0;
            }else if(newScrollX > maxLength){
                newScrollX = maxLength;
            }
            layout.scrollTo(newScrollX, 0);
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(scrollX > maxLength / 2){
                layout.scrollTo(maxLength, 0);
            }else{
                layout.scrollTo(0, 0);
            }
        }
        mlastX = x;
        return super.onTouchEvent(event);
    }

    private int dipToPX(Context context, int dip){
        return (int)(dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }
}
