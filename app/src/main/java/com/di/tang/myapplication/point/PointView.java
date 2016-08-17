package com.di.tang.myapplication.point;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;

import com.di.tang.myapplication.evaluator.PointEvaluator;

/**
 * Created by tangdi on 2016/8/16.
 */
public class PointView extends View {

    private Point point;

    public PointView(Context context) {
        super(context);
        point = new Point(20);
    }

    public PointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        point = new Point(20);
    }

    public PointView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        point = new Point(20);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(point != null){
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(400, 550, point.getRadius(), paint);
        }
    }

    public void doAnimation(){
        ValueAnimator valueAnimator = new ValueAnimator().ofObject(new PointEvaluator(),
                new Point(20), new Point(350));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                point = (Point)animation.getAnimatedValue();
                Log.d("Point", "radius = " + point.getRadius());
                invalidate();
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();
    }
}
