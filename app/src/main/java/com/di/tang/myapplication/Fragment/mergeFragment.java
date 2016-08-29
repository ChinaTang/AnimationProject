package com.di.tang.myapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.mergetag.SelfLinearLayout;

/**
 * Created by tangdi on 2016/8/29.
 */
public class mergeFragment extends Fragment implements View.OnClickListener{

    private Button scrollButton;
    private SelfLinearLayout linearLayout;
    @Override
    public void onCreate(Bundle SaveStateInstance){
        super.onCreate(SaveStateInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.merge_fragment, container, false);
        linearLayout = (SelfLinearLayout)view.findViewById(R.id.linear_);
        scrollButton = (Button)view.findViewById(R.id.scroll_by);
        scrollButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.scroll_by:
                linearLayout.scrollBy(50, 50);
        }
    }
}
