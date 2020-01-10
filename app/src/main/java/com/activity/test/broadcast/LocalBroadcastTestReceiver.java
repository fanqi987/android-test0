package com.activity.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hasse on 2020/1/8.
 */

public class LocalBroadcastTestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "这是本地广播接收器1", Toast.LENGTH_SHORT).show();
    }
}
