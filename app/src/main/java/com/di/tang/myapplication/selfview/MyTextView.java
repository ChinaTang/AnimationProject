package com.di.tang.myapplication.selfview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/26.
 */
public class MyTextView extends TextView {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        /*添加它们的主要目的，就是可以在代码中获取用户所设置的值。然后利用这些值完成我们想完成的功能。

使用代码获取某个属性用户所定义的值，主要是使用TypedArray类，这个类担供了所有的获取某个属性值的方法，
如下所示，但需要注意的是，在使用完以后必须调用TypedArray的recycle()方法，用来释放资源*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTextView);
        float headerHeight = typedArray.getDimension(R.styleable.MyTextView_headerHeight, -1);
        int age = typedArray.getInt(R.styleable.MyTextView_age, -1);
        typedArray.recycle();
        this.setText("headerHeight:"+headerHeight + "  age:"+age);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


}
