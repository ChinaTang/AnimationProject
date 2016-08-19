package com.di.tang.myapplication.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.di.tang.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by tangdi on 2016/8/19.
 */
public class SelfAdapter extends BaseAdapter {

    private int mLength = 0;

    private ArrayList<Drawable> mArrayList;

    private Context context;

    private LayoutInflater inflater;

    private Animation animation;

    private ListView mListView;

    private int mFirstTop, mFirstPosition;
    private boolean isScrollDown;


    private AbsListView.OnScrollListener  mOnScrollListener = new AbsListView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(AbsListView view, int scrollState) {

        }

        @Override
        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            View firstChild = view.getChildAt(0);
            if (firstChild == null) return;
            int top = firstChild.getTop();
            /**
             * firstVisibleItem > mFirstPosition表示向下滑动一整个Item
             * mFirstTop > top表示在当前这个item中滑动
             */
            isScrollDown = firstVisibleItem > mFirstPosition || mFirstTop > top;
            mFirstTop = top;
            mFirstPosition = firstVisibleItem;

        }
    };

    public SelfAdapter(Context context, int Length, ArrayList<Drawable> drawables, ListView listView){
        this.context = context;
        this.mLength = Length;
        mArrayList = drawables;
        inflater = LayoutInflater.from(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.list_translate);
        mListView = listView;
        mListView.setOnScrollListener(mOnScrollListener);
    }

    @Override
    public int getCount() {
        return mLength;
    }

    @Override
    public Object getItem(int position) {
        return mArrayList.get(position % mArrayList.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHold viewHold = null;
        if(convertView == null){
            viewHold = new ViewHold();
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHold.imageView = (ImageView)convertView.findViewById(R.id.image);
            viewHold.textView = (TextView)convertView.findViewById(R.id.text);
        }else{
            viewHold = (ViewHold) convertView.getTag();
        }


        //清除当前显示区域中所有item的动画
        for (int i=0;i<mListView.getChildCount();i++){
            View view = mListView.getChildAt(i);
            view.clearAnimation();
        }
        //然后给当前item添加上动画
        if (isScrollDown) {
            convertView.startAnimation(animation);
        }

        convertView.setTag(viewHold);

        viewHold.imageView.setImageDrawable(mArrayList.get(position % mArrayList.size()));
        viewHold.textView.setText(position + "");
        return convertView;
    }

    public class ViewHold{
        public ImageView imageView;
        public TextView textView;
    }
}
