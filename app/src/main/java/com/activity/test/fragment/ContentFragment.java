package com.activity.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.activity.test.R;

import org.w3c.dom.Text;

/**
 * Created by hasse on 2020/1/7.
 */

public class ContentFragment extends Fragment {
    private View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.content_fragment,container,false);
        return v;
    }

    public void fresh(String title,String content){
        //todo
        TextView tv= (TextView) v.findViewById(R.id.content_fragment_title);
        tv.setText(title);
        TextView tv2= (TextView) v.findViewById(R.id.content_fragment_content);
        tv2.setText(content);
    }
}
