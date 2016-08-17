package com.di.tang.myapplication.Fragment;

import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/16.
 */
public class SelfObjectAnimator extends Fragment {

    private PopupWindow popupWindow;
    private Button start, cancle, alpha, rotation, xrotation, yrotation, xyrotation,
    xscale, yscale, xyscale, ytranslation, xtranslation;
    private TextView text;
    private ObjectAnimator alphaAnimator, rotationAnimator, xrotationAnimator,
            yrotationAnimator, xrotationAnimation,
            yrotationAnimation, xrotationSign, yrotationSign, xScaleAnimator,
            ytranslationAnimator, xtranslationAnimator, yScaleAnimator;
    private Animation alpahViewAnimation, rotationAnimation;
    private View popupView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.object_animation, container, false);
        {
            popupView = inflater.inflate(R.layout.popup_window, null);
            alpha = (Button)popupView.findViewById(R.id.popup_alpha);
            rotation = (Button)popupView.findViewById(R.id.popup_rotation);
            xrotation = (Button)popupView.findViewById(R.id.popup_xrotation);
            yrotation = (Button)popupView.findViewById(R.id.popup_yrotation);
            xyrotation = (Button)popupView.findViewById(R.id.popup_xyrotation);
            xscale = (Button)popupView.findViewById(R.id.popup_xscale);
            yscale = (Button)popupView.findViewById(R.id.popup_yscale);
            xyscale = (Button)popupView.findViewById(R.id.popup_xyscale);
            ytranslation = (Button)popupView.findViewById(R.id.popup_ytranslation);
            xtranslation = (Button)popupView.findViewById(R.id.popup_xtranslation);
        }

        start = (Button)view.findViewById(R.id.start_bn);
        cancle = (Button)view.findViewById(R.id.cancel_bn);
        text = (TextView)view.findViewById(R.id.tv);

        alphaAnimator = ObjectAnimator.ofFloat(text, "alpha", 1, 0, 1);
        alphaAnimator.setDuration(7000);

        rotationAnimator = ObjectAnimator.ofFloat(text, "rotation", 0, 180, 0);
        rotationAnimator.setDuration(7000);
        rotationAnimator.setInterpolator(new BounceInterpolator());

        xrotationAnimator = ObjectAnimator.ofFloat(text, "rotationX", 0, 270, 0);
        xrotationAnimator.setDuration(7000);

        xrotationAnimation = ObjectAnimator.ofFloat(xrotation, "rotationX", 0, 270, 0);
        xrotationAnimation.setDuration(7000);

        yrotationAnimation = ObjectAnimator.ofFloat(yrotation, "rotationY", 0, 270, 0);
        yrotationAnimation.setDuration(7000);

        yrotationAnimator = ObjectAnimator.ofFloat(text, "rotationY", 0, 270, 0);
        yrotationAnimator.setDuration(7000);

        xrotationSign = ObjectAnimator.ofFloat(xyrotation, "rotationX", 0, 360, 0);
        xrotationSign.setDuration(7000);
        yrotationSign = ObjectAnimator.ofFloat(xyrotation, "rotationY", 0, 360, 0);
        yrotationSign.setDuration(7000);

        alpahViewAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_animation);
        rotationAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.rotation_animation);




        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow = new PopupWindow();

                popupWindow.setContentView(popupView);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setWidth(start.getWidth());
                popupWindow.setFocusable(true);

                ColorDrawable dw = new ColorDrawable(0000000);
                popupWindow.setBackgroundDrawable(dw);
                //popupWindow.setAnimationStyle(R.style.popup_window_style);
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(start, start.getLayoutParams().width, 18);
                    {
                        alpha.startAnimation(alpahViewAnimation);
                        rotation.startAnimation(rotationAnimation);
                    }

                    {
                        xrotationAnimation.start();
                        yrotationAnimation.start();
                    }

                    {
                        xrotationSign.start();
                        yrotationSign.start();
                    }

                    {
                        xScaleAnimator = ObjectAnimator.ofFloat(xscale, "scaleX", 0, 3, 1);
                        xScaleAnimator.setDuration(7000);
                        xScaleAnimator.start();
                    }

                    {
                        yScaleAnimator = ObjectAnimator.ofFloat(yscale, "scaleY", 0, 3, 1);
                        yScaleAnimator.setDuration(7000);
                        yScaleAnimator.start();
                    }

                    {
                        xScaleAnimator = ObjectAnimator.ofFloat(xyscale, "scaleX", 0, 3, 1);
                        xScaleAnimator.setDuration(7000);
                        yScaleAnimator = ObjectAnimator.ofFloat(xyscale, "scaleY", 0, 3, 1);
                        yScaleAnimator.setDuration(7000);
                        xScaleAnimator.start();
                        yScaleAnimator.start();
                    }

                    {
                        ytranslationAnimator = ObjectAnimator.
                                ofFloat(ytranslation, "translationY" , 0, 3, 0, -3, 0);
                        ytranslationAnimator.setDuration(200);
                        ytranslationAnimator.setRepeatCount(35);
                        ytranslationAnimator.setRepeatMode(ObjectAnimator.REVERSE);
                        ytranslationAnimator.start();
                    }

                    {
                        xtranslationAnimator = ObjectAnimator.
                                ofFloat(xtranslation, "translationX", 0, 3, 0, -3, 0);
                        xtranslationAnimator.setDuration(200);
                        xtranslationAnimator.setRepeatCount(35);
                        xtranslationAnimator.setRepeatMode(ObjectAnimator.REVERSE);
                        xtranslationAnimator.start();
                    }

                } else {
                    popupWindow.dismiss();
                }

            }
        });
        alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alphaAnimator.start();
            }
        });
        rotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotationAnimator.start();
            }
        });
        xrotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xrotationAnimator.start();
            }
        });
        yrotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yrotationAnimator.start();
            }
        });

        xyrotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yrotationAnimator.start();
                xrotationAnimator.start();
            }
        });

        xscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //xScaleAnimator.cancel();
                //xscale.clearAnimation();
                xScaleAnimator.end();
                xScaleAnimator = ObjectAnimator.ofFloat(text, "scaleX", 0, 3, 1);
                xScaleAnimator.setDuration(7000);
                xScaleAnimator.start();
            }
        });

        yscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yScaleAnimator.end();
                yScaleAnimator = ObjectAnimator.ofFloat(text, "scaleY", 0, 3, 1);
                yScaleAnimator.setDuration(7000);
                yScaleAnimator.start();
            }
        });

        xyscale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xScaleAnimator.end();
                xScaleAnimator = ObjectAnimator.ofFloat(text, "scaleX", 0, 3, 1);
                xScaleAnimator.setDuration(7000);
                xScaleAnimator.start();
                yScaleAnimator.end();
                yScaleAnimator = ObjectAnimator.ofFloat(text, "scaleY", 0, 3, 1);
                yScaleAnimator.setDuration(7000);
                yScaleAnimator.start();

            }
        });

        xtranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xtranslationAnimator.end();
                xtranslationAnimator = ObjectAnimator.
                        ofFloat(text, "translationX" , 0, 100, -100 ,0);
                xtranslationAnimator.setDuration(7000);
                xtranslationAnimator.start();
            }
        });

        ytranslation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ytranslationAnimator.end();
                ytranslationAnimator = ObjectAnimator.
                        ofFloat(text, "translationY" , 0, 100, -100 ,0);
                ytranslationAnimator.setDuration(7000);
                ytranslationAnimator.start();
            }
        });

        return view;
    }
}
