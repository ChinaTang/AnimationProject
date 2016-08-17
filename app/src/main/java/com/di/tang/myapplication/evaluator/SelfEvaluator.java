package com.di.tang.myapplication.evaluator;

import android.animation.TypeEvaluator;

/**
 * Created by tangdi on 2016/8/16.
 */
public class SelfEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float v, Character character, Character t1) {
        int start = (int)character;
        int end = (int)t1;
        int curVal = (int)(start + v * (end - start));
        return (char)curVal;
    }
}
