package com.di.tang.myapplication.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.di.tang.myapplication.R;
import com.di.tang.myapplication.selfview.CustomScrollViewUtilization;

import java.util.zip.Inflater;

/**
 * Created by tangdi on 2016/8/29.
 */
public class CustomScrollViewUtilizationFragment extends Fragment {

    private TableLayout tableLayout;
    @Override
    public void onCreate(Bundle saveStateInstacne){
        super.onCreate(saveStateInstacne);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.custom_scroll_view_utilization, root, false);
        tableLayout = (TableLayout)view.findViewById(R.id.table_layout);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        showTable();
        CustomScrollViewUtilization customScrollViewUtilization =
                (CustomScrollViewUtilization)view.findViewById(R.id.custom_scroll_view_utilization);
        customScrollViewUtilization.setHeaderView(imageView);
        return view;
    }

    private void showTable(){
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.leftMargin = 30;
        layoutParams.bottomMargin = 10;
        layoutParams.topMargin = 10;

        for(int i = 0; i < 30; i++){
            TableRow tableRow = new TableRow(getActivity());
            TextView textView = new TextView(getActivity());
            textView.setText("ScrollView" + i);
            textView.setTextSize(20);
            textView.setPadding(15, 15, 15, 15);
            tableRow.addView(textView);
            if(i % 2 != 0){
                tableRow.setBackgroundColor(Color.WHITE);
            }else{
                tableRow.setBackgroundColor(Color.BLACK);
            }
            tableLayout.addView(tableRow);
        }

    }
}
