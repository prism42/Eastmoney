package com.tkid.eastmoney.ui.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.tkid.appsdk.base.FragmentPagerAdapter;
import com.tkid.eastmoney.R;

/**
 * 
 */
public class BuyFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    int selectPager = 0;
    FragmentPagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView(View view) {
        viewPager = view.findViewById(R.id.viewpager_fragment_buy);
        tabLayout = view.findViewById(R.id.tablayout_fragment_buy);

        mPagerAdapter = new FragmentPagerAdapter(getActivity());
        mPagerAdapter.addFragment(new BuyFragment(),"我的持仓");
        mPagerAdapter.addFragment(new SellFragment(),"当日成交");
        mPagerAdapter.addFragment(new RevokeFragment(), "当日委托");
        viewPager.setAdapter(mPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，一个动另一个也会跟着动
        tabLayout.setTabTextColors(getActivity().getColor(R.color.black), getActivity().getColor(R.color.orange_bg2));
//        tabLayout.setSelectedTabIndicatorColor(getColor(R.color.white));
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setTabIndicatorFullWidth(true);
        viewPager.setCurrentItem(selectPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}