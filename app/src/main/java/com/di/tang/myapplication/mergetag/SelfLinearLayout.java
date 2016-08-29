package com.di.tang.myapplication.mergetag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/29.
 */
public class SelfLinearLayout extends LinearLayout {
    public SelfLinearLayout(Context context) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.merge_layout, this, true);
    }

    public SelfLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.merge_layout, this, true);
    }

    public SelfLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(LinearLayout.HORIZONTAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.merge_layout, this, true);
    }
}
