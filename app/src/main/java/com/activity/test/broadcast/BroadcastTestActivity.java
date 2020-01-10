package com.activity.test.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.activity.test.R;

/**
 * Created by hasse on 2020/1/8.
 */

public class BroadcastTestActivity extends Activity {

    private BroadcastTestReceiver btr;
    private IntentFilter iff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        btr = new BroadcastTestReceiver();
        iff = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(btr, iff);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(btr);
    }

    class BroadcastTestReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni != null && ni.isAvailable()) {
                Toast.makeText(context, "网络可用", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "网络不可用", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
