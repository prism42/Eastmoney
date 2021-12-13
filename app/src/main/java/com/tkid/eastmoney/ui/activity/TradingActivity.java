package com.tkid.eastmoney.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.jaeger.library.StatusBarUtil;
import com.tkid.appsdk.base.FragmentPagerAdapter;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.ui.fragment.BuyFragment;
import com.tkid.eastmoney.ui.fragment.CommissionedFragment;
import com.tkid.eastmoney.ui.fragment.InventoryFragment;
import com.tkid.eastmoney.ui.fragment.RevokeFragment;
import com.tkid.eastmoney.ui.fragment.SellFragment;

public class TradingActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    int selectPager = 0;
    FragmentPagerAdapter mPagerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trading);
        StatusBarUtil.setColor(TradingActivity.this, getColor(R.color.orange_bg2));
        StatusBarUtil.setTransparent(TradingActivity.this);
        selectPager = getIntent().getIntExtra("VIEWPAGER",0);
        initView();

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        //实例化
        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);

        mPagerAdapter = new FragmentPagerAdapter(this);
        mPagerAdapter.addFragment(new BuyFragment(),"买入");
        mPagerAdapter.addFragment(new SellFragment(),"卖出");
        mPagerAdapter.addFragment(new RevokeFragment(), "撤单");
        mPagerAdapter.addFragment(new CommissionedFragment(), "委托成交");
        mPagerAdapter.addFragment(new InventoryFragment(), "持仓");
        viewPager.setAdapter(mPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，一个动另一个也会跟着动
        tabLayout.setTabTextColors(getColor(R.color.orange_bg), getColor(R.color.white));
        tabLayout.setSelectedTabIndicatorColor(getColor(R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabIndicatorFullWidth(true);
        viewPager.setCurrentItem(selectPager);
        tabLayout.setupWithViewPager(viewPager);
    }

}