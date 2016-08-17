package com.di.tang.myapplication.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.di.tang.myapplication.Fragment.SelfObjectAnimator;
import com.di.tang.myapplication.Fragment.SelfValueAnimator;
import com.di.tang.myapplication.Fragment.SelfViewAnimation;
import com.di.tang.myapplication.R;


public class MainActivity extends AppCompatActivity {

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
                }else{
                    return new SelfViewAnimation();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
    }
}
