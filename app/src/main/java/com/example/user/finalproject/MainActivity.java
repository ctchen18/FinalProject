package com.example.user.finalproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.user.finalproject.adapter.ViewPagerAdapter;
import com.example.user.finalproject.fragment.CenterFragment;
import com.example.user.finalproject.fragment.LeftFragment;
import com.example.user.finalproject.fragment.RightFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //private ViewPager viewPager;
    //private TableLayout tableLayout;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_Layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }
    public void initView(){
        fragmentList.add(new LeftFragment());
        fragmentList.add(new CenterFragment());
        fragmentList.add(new RightFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);



    }



}
