package com.activity.test;

//import android.support.v7.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.activity.test.broadcast.BroadcastTestActivity;
import com.activity.test.broadcast.LocalBroadcastTestReceiver;

import junit.framework.Test;

/**
 * Created by hasse on 2020/1/5.
 */

public class TestActivity extends Activity {

    private Button button1;

    private LocalBroadcastTestReceiver lbtr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test);
        button1 = (Button) findViewById(R.id.test_button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TestActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
        findViewById(R.id.test_button_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.activity.test.ThirdActivity.ACTION_START");
                i.addCategory("com.activity.test.ThirdActivity.CATEGORY_START");
                startActivity(i);
            }
        });
        findViewById(R.id.test_button_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.baidu.com"));
                startActivity(i);
            }
        });
        findViewById(R.id.test_button_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:10086"));
                startActivity(i);
            }
        });
        findViewById(R.id.test_button_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("http://www.qq.com"));
                startActivity(i);
            }
        });
        float xdpi = getResources().getDisplayMetrics().xdpi;
        float ydpi = getResources().getDisplayMetrics().ydpi;
        Log.d("xdpi", String.valueOf(xdpi));
        Log.d("ydpi", String.valueOf(ydpi));
        findViewById(R.id.test_button_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, FifthActivity.class));
            }
        });
        findViewById(R.id.test_button_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, SixthActivity.class));
            }
        });

        findViewById(R.id.test_button_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TestActivity.this, BroadcastTestActivity.class));
            }
        });

        findViewById(R.id.test_button_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.activity.test.broadcast.MY_BROADCAST");
                sendOrderedBroadcast(i, null);
            }
        });

        lbtr = new LocalBroadcastTestReceiver();
        IntentFilter iff = new IntentFilter();
        iff.addAction("com.activity.test.broadcast.MY_BROADCAST");
        LocalBroadcastManager.getInstance(TestActivity.this).registerReceiver(lbtr, iff);

        findViewById(R.id.test_button_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent("com.activity.test.broadcast.MY_BROADCAST");
                LocalBroadcastManager.getInstance(TestActivity.this).sendBroadcast(i);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(lbtr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_1:
                Toast.makeText(this, "点击了item1", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
