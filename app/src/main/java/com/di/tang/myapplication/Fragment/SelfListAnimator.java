package com.di.tang.myapplication.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.adapter.SelfAdapter;

import java.util.ArrayList;

/**
 * Created by tangdi on 2016/8/18.
 */
public class SelfListAnimator extends ListFragment {

    private ArrayList<Drawable> drawables;

    private int mFirstTop, mFirstPosition;
    private static boolean isScrollDown;
    @Override
    public void onCreate(Bundle saveInstanceBundle){
        super.onCreate(saveInstanceBundle);
        drawables = new ArrayList<>();
        drawables.add(getResources().getDrawable(R.drawable.pic1));
        drawables.add(getResources().getDrawable(R.drawable.pic2));
        drawables.add(getResources().getDrawable(R.drawable.pic3));
        drawables.add(getResources().getDrawable(R.drawable.pic4));
        drawables.add(getResources().getDrawable(R.drawable.pic5));
        drawables.add(getResources().getDrawable(R.drawable.pic6));
        drawables.add(getResources().getDrawable(R.drawable.pic7));
        drawables.add(getResources().getDrawable(R.drawable.pic8));
        drawables.add(getResources().getDrawable(R.drawable.pic9));

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new SelfAdapter(getContext(), 300, drawables, getListView()));

    }






}
