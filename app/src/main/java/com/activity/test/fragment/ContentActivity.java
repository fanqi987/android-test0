package com.activity.test.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.activity.test.R;
import com.activity.test.bean.News;

/**
 * Created by hasse on 2020/1/7.
 */

public class ContentActivity extends FragmentActivity {

    public static void startAction(Context c, News news){
        Intent i=new Intent(c,ContentActivity.class);
        i.putExtra("title",news.getTitle());
        i.putExtra("content",news.getContent());
        c.startActivity(i);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_fragment);
        Intent i=getIntent();
        String title=i.getStringExtra("title");
        String content=i.getStringExtra("content");

        TextView tvTitle= (TextView) findViewById(R.id.content_fragment_title);
        tvTitle.setText(title);
        TextView tvContent= (TextView) findViewById(R.id.content_fragment_content);
        tvContent.setText(content);
    }

}
