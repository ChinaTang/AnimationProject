package com.di.tang.myapplication.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.di.tang.myapplication.R;

/**
 * Created by tangdi on 2016/8/26.
 */
public class CustomScrollViewFragment extends Fragment {
    @Override
    public void onCreate(Bundle saveStateInstance){

        super.onCreate(saveStateInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.customer_scroll_view, container, false);
        return view;
    }
}
