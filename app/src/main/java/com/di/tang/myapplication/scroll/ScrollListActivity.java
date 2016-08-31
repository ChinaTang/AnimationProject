package com.di.tang.myapplication.scroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.di.tang.myapplication.R;

import java.util.ArrayList;

/**
 * Created by tangdi on 2016/8/31.
 */
public class ScrollListActivity extends AppCompatActivity {

    private ScrollListView listView;

    private ArrayList<ScrollListAdapter.DataHold> dataHolds = new ArrayList<>();

    private ScrollListAdapter scrollListAdapter;

    private void fillData(){
        for(int i = 0; i < 20; i++){
            ScrollListAdapter.DataHold dataHold = new ScrollListAdapter.DataHold();
            dataHold.title = "第" + i + "列表项";
            dataHolds.add(dataHold);
        }
    }
    @Override
    public void onCreate(Bundle saveStateInstance){
        super.onCreate(saveStateInstance);
        setContentView(R.layout.scroll_listview_activity);
        listView = (ScrollListView)findViewById(R.id.scroll_list_view);
        fillData();
        scrollListAdapter = new ScrollListAdapter(dataHolds, ScrollListActivity.this, listView);
        listView.setAdapter(scrollListAdapter);
    }
}
