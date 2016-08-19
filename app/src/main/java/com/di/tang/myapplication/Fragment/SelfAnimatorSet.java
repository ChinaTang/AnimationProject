package com.di.tang.myapplication.Fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/18.
 */
public class SelfAnimatorSet extends Fragment {
    /*首先，AnimatorSet针对ValueAnimator和ObjectAnimator都是适用的，但一般而言，
    我们不会用到ValueAnimator的组合动画，所以我们这篇仅讲解ObjectAnimator下的组合动画实现。
    在AnimatorSet中直接给为我们提供了两个方法playSequentially和playTogether，playSequentially表示所有
    动画依次播放，playTogether表示所有动画一起开始*/

    private Button start, startTog, startFree;
    private TextView tv1, tv2;
    private ObjectAnimator rotationAnimator1, rotationAnimator2 , colorAnimator;
    private AnimatorSet animatorSet, animatorTOG, animatorFree;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view  = inflater.inflate(R.layout.animation_set, container, false);
        {
            tv1 = (TextView) view.findViewById(R.id.text1);
            tv2 = (TextView) view.findViewById(R.id.text2);
            start= (Button) view.findViewById(R.id.start_bn);
            startTog = (Button) view.findViewById(R.id.start_bn01);
            startFree = (Button) view.findViewById(R.id.start_bn02);
            startFree.setEnabled(false);
        }

        {
            rotationAnimator1 = ObjectAnimator.ofFloat(tv1, "translationY", 0 , 100, 0);
        }

        {
            rotationAnimator2 = ObjectAnimator.ofFloat(tv2, "translationY", 0, 100, 0);
        }


        {
            colorAnimator = ObjectAnimator.ofInt(tv2, "backgroundColor",
                    0xffff00ff, 0xffffff00, 0xffff00ff);
            colorAnimator.setInterpolator(new BounceInterpolator());
        }


        animatorSet = new AnimatorSet();
        animatorTOG = new AnimatorSet();
        animatorFree = new AnimatorSet();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorSet.playSequentially(rotationAnimator1, colorAnimator, rotationAnimator2);
                animatorSet.setDuration(1000);
                animatorSet.start();
            }
        });

        startTog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animatorTOG.playTogether(rotationAnimator1, colorAnimator, rotationAnimator2);
                animatorTOG.setDuration(1000);
                animatorTOG.start();
            }
        });

        startFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimatorSet.Builder builder = animatorFree.play(colorAnimator);
                builder.after(rotationAnimator1);
                builder.with(rotationAnimator2);
                animatorFree.start();
            }
        });


        return view;
    }
}
