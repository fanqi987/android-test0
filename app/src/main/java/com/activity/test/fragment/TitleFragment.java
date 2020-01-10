package com.activity.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.activity.test.R;
import com.activity.test.adapter.TitleListAdapter;
import com.activity.test.bean.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasse on 2020/1/7.
 */

public class TitleFragment extends Fragment {

    TitleListAdapter adapter;
    List<News> news;
    private boolean isTwoPane;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initNews();
        initAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.title_fragment, container, false);

        Log.e("titlefragment", "created view");
        //todo
        ListView lv = (ListView) (v.findViewById(R.id.title_lv));

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!isTwoPane) {
                    ContentActivity.startAction(getActivity(), news.get(i));
                } else {
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    ContentFragment contentFragment = (ContentFragment) fm.findFragmentById(R.id.left_fragment_news);
                    contentFragment.fresh(news.get(i).getTitle(), news.get(i).getContent());
                }
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null == getActivity().findViewById(R.id.left_fragment_news)) {
            isTwoPane = false;
        } else {
            isTwoPane = true;
        }
    }

    private void initAdapter() {
        //TODO
        adapter = new TitleListAdapter(getActivity(), R.layout.title_item, news);
    }

    private void initNews() {
        news = new ArrayList();
        news.add(new News("Flyme 8 体验：可能是最好的国产安卓系统",
                "我们这样的疑问：作为国内定制安卓系统双璧之一的 Flyme。 " +
                        "在落后友商一代的情况下，还能守住这份荣誉吗？ 现在，过去一周，" +
                        "我们可以回答这个问题了。"));
        news.add(new News("与安卓/iOS对抗8年！第三大操作系统最终还是凉了", "因对Windows 10 Mobile" +
                "（前身是Windows Phone）设备的支持将于2019年12月10日结束，微软建议目前的Windows 10 " +
                "Mobile用户改用Android或iOS设备。"));
    }
}
