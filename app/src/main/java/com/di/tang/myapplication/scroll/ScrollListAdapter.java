package com.di.tang.myapplication.scroll;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.di.tang.myapplication.R;

import java.util.ArrayList;

/**
 * Created by tangdi on 2016/8/31.
 */
public class ScrollListAdapter extends BaseAdapter {

    private static final int MAXSIZE = 200;

    private int dipToPX(Context context, int dip){
        return (int)(dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }

    private int maxLength;

    public static class DataHold{
        public String title;
        public LinearLayout layout;
        public boolean isScroll = false;
    }

    private static class ViewHold{
        public TextView title;
    }

    private ArrayList<DataHold> dataHolds;

    private Context context;

    private ListView listView;

    private LayoutInflater layoutInflater;

    public ScrollListAdapter(ArrayList<DataHold> dataHolds, Context context, ListView listView){
        this.dataHolds = dataHolds;
        this.context = context;
        this.listView = listView;
        layoutInflater = LayoutInflater.from(context);
        maxLength = dipToPX(context, MAXSIZE);
    }

    @Override
    public int getCount() {
        return dataHolds.size();
    }

    @Override
    public Object getItem(int i) {
        return dataHolds.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHold viewHold;
        if(view == null || view.getTag() == null){
            view = layoutInflater.inflate(R.layout.scroll_list_item, viewGroup, false);
            viewHold = new ViewHold();
            viewHold.title = (TextView) view.findViewById(R.id.title);
            view.setTag(viewHold);
        }else{
            viewHold = (ViewHold) view.getTag();
        }
        viewHold.title.setText(dataHolds.get(i).title);
        dataHolds.get(i).layout = (LinearLayout)view.findViewById(R.id.lin_root);
        if(!dataHolds.get(i).isScroll){
            dataHolds.get(i).layout.scrollTo(0, 0);
        }else{
            dataHolds.get(i).layout.scrollTo(maxLength, 0);
        }
        return view;
    }
}
