package com.di.tang.myapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.di.tang.myapplication.Fragment.CustomScrollViewFragment;
import com.di.tang.myapplication.Fragment.CustomScrollViewUtilizationFragment;
import com.di.tang.myapplication.Fragment.MyTextViewFragment;
import com.di.tang.myapplication.Fragment.ScrollViewBaseFragment;
import com.di.tang.myapplication.Fragment.SelfAnimatorSet;
import com.di.tang.myapplication.Fragment.SelfListAnimator;
import com.di.tang.myapplication.Fragment.SelfObjectAnimator;
import com.di.tang.myapplication.Fragment.SelfPropertyValuesHolder;
import com.di.tang.myapplication.Fragment.SelfValueAnimator;
import com.di.tang.myapplication.Fragment.SelfViewAnimation;
import com.di.tang.myapplication.Fragment.SelfXmlAnimator;
import com.di.tang.myapplication.Fragment.mergeFragment;
import com.di.tang.myapplication.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public interface MyTouchListener{
        public boolean onSelfTouchEvent(MotionEvent event);
    }

    public ArrayList<MyTouchListener>  listeners = new ArrayList<>();

    public void addTochListenter(MyTouchListener listener){
        listeners.add(listener);
    }

    public void removeTochListenter(MyTouchListener listener){
        listeners.remove(listener);
    }

    public void clearTochuListener(){
        listeners.clear();
    }

    private static final String TAG = "MainActivity";

    private ViewPager mViewPager;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager)findViewById(R.id.viewpage);
        fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return new SelfViewAnimation();
                }else if(position == 1){
                    return  new SelfValueAnimator();
                }else if(position == 2){
                    return new SelfObjectAnimator();
                }else if(position == 3){
                    return new SelfPropertyValuesHolder();
                }else if(position == 4){
                    return new SelfAnimatorSet();
                }else if(position == 5){
                    return new SelfXmlAnimator();
                }else if(position == 6){
                    return new SelfListAnimator();
                }else if(position == 7){
                    return new MyTextViewFragment();
                }else if(position == 8){
                    return new CustomScrollViewFragment();
                }else if(position == 9){
                    return new CustomScrollViewUtilizationFragment();
                }else if(position == 10){
                    return new mergeFragment();
                }else if(position == 11){
                    return new ScrollViewBaseFragment();
                }else{
                    return new SelfViewAnimation();
                }
            }

            @Override
            public int getCount() {
                return 12;
            }
        });
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev){
        for(MyTouchListener listener : listeners){
            return listener.onSelfTouchEvent(ev);
        }
        return false;
    }

}
