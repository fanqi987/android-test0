package com.activity.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by hasse on 2020/1/8.
 */

public class BroadcastTestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"系统已启动",Toast.LENGTH_SHORT).show();
    }
}
