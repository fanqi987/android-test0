package com.activity.test.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.activity.test.R;
import com.activity.test.bean.News;

import java.util.List;

/**
 * Created by hasse on 2020/1/7.
 */

public class TitleListAdapter extends ArrayAdapter<News> {

    private int rid;
    private List news;
    private Context context;

    public TitleListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.rid = resource;
        this.news = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News ne = (News) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(rid, null);
        }
        //todo
        TextView tv = (TextView) convertView.findViewById(R.id.title_item_tv);
        tv.setText(ne.getTitle());
        return convertView;
    }
}
