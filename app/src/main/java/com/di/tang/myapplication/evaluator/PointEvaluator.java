package com.di.tang.myapplication.evaluator;

import android.animation.TypeEvaluator;

import com.di.tang.myapplication.point.Point;

/**
 * Created by tangdi on 2016/8/16.
 */
public class PointEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        int radius = (int)(startValue.getRadius() +
                fraction * (endValue.getRadius() - startValue.getRadius()));
        return new Point(radius);
    }
}
