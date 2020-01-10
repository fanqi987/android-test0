package com.activity.test.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.activity.test.R;

/**
 * Created by hasse on 2020/1/7.
 */

public class RightFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.right_fragment_2, container, false);
        Log.e("aaaa", "right fragment2 created view");
        return v;
    }
}
