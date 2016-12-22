package com.talon.viewpagerdemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tablayout_main)
    TabLayout tablayoutMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<String> title = new ArrayList<>();
        List<ImageView> listviews = new ArrayList<>();
        Class<R.mipmap> clz = R.mipmap.class;

        for (int i = 0; i < 5; i++) {
            ImageView img = new ImageView(this);
            try {
                img.setImageResource(clz.getField("img" + i).getInt(null));
            } catch (Exception e) {
                e.printStackTrace();
            }
            listviews.add(img);
            title.add("Talon" + i);
            tablayoutMain.addTab(tablayoutMain.newTab().setText(title.get(i)));
        }
        vpMain.setAdapter(new MyPageAdapter(title, listviews));
        tablayoutMain.setupWithViewPager(vpMain);
    }
}
