package com.di.tang.myapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.activity.MainActivity;

/**
 * Created by tangdi on 2016/8/30.
 */
public class ScrollViewBaseFragment extends Fragment implements MainActivity.MyTouchListener {

    /*ScrollBy()和ScrollTo并没有移动画布和布局，只是移动了画布的显示区域，在android中画布的大小
    是无限的，不受物理屏幕的约束， ScroolTo(100, 100), 只是显示区域向右下移动了*/
    private LinearLayout layout;
    private int mlastX = 0;
    private MainActivity mainActivity;

    @Override
    public void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup content, Bundle saveStateInstance){
        View view = inflater.inflate(R.layout.scroll_base, content, false);
        layout = (LinearLayout)view.findViewById(R.id.linear);
        return view;
    }


    @Override
    public boolean onSelfTouchEvent(MotionEvent event) {
        int scrollX = layout.getScrollX();
        int x = (int)event.getX();
        if(event.getAction() == MotionEvent.ACTION_MOVE){
            int newScrollX = scrollX + mlastX - x;
            layout.scrollBy(newScrollX, 0);
        }
        mlastX = x;
        return false;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity = (MainActivity)context;
        mainActivity.addTochListenter(this);
    }

    @Override
    public void onPause(){
        super.onPause();
        mainActivity.clearTochuListener();
    }
}
