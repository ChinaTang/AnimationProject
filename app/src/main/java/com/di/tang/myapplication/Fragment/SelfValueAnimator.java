package com.di.tang.myapplication.Fragment;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.evaluator.SelfEvaluator;
import com.di.tang.myapplication.point.PointView;

/**
 * Created by tangdi on 2016/8/16.
 */
public class SelfValueAnimator extends Fragment {

    private Button start, cancel, animationView;
    private ValueAnimator mValueAnimator, mColorValueAnimator, mTextValueAnimator;
    private PointView pointView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.value_animation, container, false);
        start = (Button) view.findViewById(R.id.start_bn);
        cancel = (Button) view.findViewById(R.id.cancel_bn);
        animationView = (Button) view.findViewById(R.id.view_bn);
        pointView = (PointView)view.findViewById(R.id.point_view);


        mValueAnimator = new ValueAnimator().ofInt(0, 400);
        mValueAnimator.setDuration(7000);
        mValueAnimator.setInterpolator(new BounceInterpolator());
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (int) valueAnimator.getAnimatedValue();
                Log.d("AAA", "" + val);
                animationView.layout(animationView.getLeft(), val,
                        animationView.getRight(), animationView.getHeight() + val);
            }
        });

        mColorValueAnimator = new ValueAnimator().ofInt(0xffffff00, 0xff0000ff);
        mColorValueAnimator.setEvaluator(new ArgbEvaluator());
        mColorValueAnimator.setDuration(7000);
        mColorValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (int) valueAnimator.getAnimatedValue();
                animationView.setBackgroundColor(val);
            }
        });

        mTextValueAnimator = new ValueAnimator().ofObject(new SelfEvaluator(), 'A', 'Z');
        mTextValueAnimator.setDuration(7000);
        mTextValueAnimator.setInterpolator(new AccelerateInterpolator());
        mTextValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char text = (char) valueAnimator.getAnimatedValue();
                animationView.setText(String.valueOf(text));
                Log.d("BBBB", "height" + animationView.getHeight() + "," +
                        "bottom" + animationView.getBottom());
            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextValueAnimator.start();
                mValueAnimator.start();
                mColorValueAnimator.start();
            }
        });

        pointView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointView.doAnimation();
            }
        });

        return view;
    }

}
