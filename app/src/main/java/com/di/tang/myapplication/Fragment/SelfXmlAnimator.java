package com.di.tang.myapplication.Fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/18.
 */
public class SelfXmlAnimator extends Fragment{

    private Button menun, item1, item2, item3, item4, item5;

    private boolean isOpen = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.menu_popup, container, false);
        menun = (Button)view.findViewById(R.id.btn_start);
        item1 = (Button)view.findViewById(R.id.btn_item1);
        item2 = (Button)view.findViewById(R.id.btn_item2);
        item3 = (Button)view.findViewById(R.id.btn_item3);
        item4 = (Button)view.findViewById(R.id.btn_item4);
        item5 = (Button)view.findViewById(R.id.btn_item5);

        menun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isOpen){
                    isOpen = true;
                    doAnimatorOpen(item1, 0, 5, 300);
                    doAnimatorOpen(item2, 1, 5, 300);
                    doAnimatorOpen(item3, 2, 5, 300);
                    doAnimatorOpen(item4, 3, 5, 300);
                    doAnimatorOpen(item5, 4, 5, 300);
                }else{
                    isOpen = false;
                    doAnimatorClose(item1, 0, 5, 300);
                    doAnimatorClose(item2, 1, 5, 300);
                    doAnimatorClose(item3, 2, 5, 300);
                    doAnimatorClose(item4, 3, 5, 300);
                    doAnimatorClose(item5, 4, 5, 300);
                }
            }
        });
        return view;
    }

    private void doAnimatorOpen(View view, int index, int total, int radius){
        if(view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians(90)/(total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));



        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1)
        );
        animatorSet.setStartDelay(index * 100);
        animatorSet.setDuration(500).start();
    }

    private void doAnimatorClose(final View view, int index, int total, int radius){
        if(view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians(90)/(total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));



        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY,0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0)
        );
        animatorSet.setStartDelay(index * 100);
        animatorSet.setDuration(500).start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
