package com.di.tang.myapplication.Fragment;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/16.
 */
public class SelfViewAnimation extends Fragment {

    private static final String TAG = "SelfViewAnimation";

    private Button scaleBtn, rotateBtn, transBtn, setBtn, valueBtn;
    private Animation scaleAnimation, rotateAnimation, translateAnimation, setAnimation;
    private ValueAnimator mValueAnimator;
    private TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.view_animation, container, false);

        scaleAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.scale_1);
        rotateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_1);
        translateAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_1);
        setAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.set_1);

        mValueAnimator = new ValueAnimator().ofInt(400);

        mValueAnimator.setDuration(10000);

        scaleBtn = (Button)view.findViewById(R.id.bn);
        rotateBtn = (Button)view.findViewById(R.id.bn_rotate);
        transBtn = (Button)view.findViewById(R.id.bn_translate);
        setBtn = (Button)view.findViewById(R.id.bn_set);
        valueBtn = (Button)view.findViewById(R.id.value);
        tv =(TextView)view.findViewById(R.id.tv);

        valueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mValueAnimator.start();
            }
        });
        scaleBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                tv.startAnimation(scaleAnimation);
            }
        });
        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.startAnimation(rotateAnimation);
            }
        });
        transBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.startAnimation(translateAnimation);
            }
        });
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.startAnimation(setAnimation);
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), R.string.toast, Toast.LENGTH_SHORT).show();
            }
        });

        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (int)valueAnimator.getAnimatedValue();
                Log.d(TAG , String.valueOf(val));
                tv.layout(val, val, tv.getWidth() + val, tv.getHeight() + val);
            }
        });

        mValueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        return view;
    }

}
