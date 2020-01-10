package com.activity.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by hasse on 2020/1/7.
 */

public class FifthActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        Log.e("aaaa", "fifth activity created");
        Button b1 = (Button) findViewById(R.id.left_fragment_btn);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RightFragment2 f = new RightFragment2();
//                FragmentManager fm = FifthActivity.this.getSupportFragmentManager();
//                Log.e("aaaa", "fragment2 ready to create");
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.right_layout, f);
//                ft.addToBackStack(null);
//                ft.commit();
            }
        });
    }
}
