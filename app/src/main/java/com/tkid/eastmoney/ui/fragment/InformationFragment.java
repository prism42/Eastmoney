package com.tkid.eastmoney.ui.fragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.tkid.appsdk.base.FragmentPagerAdapter;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.databinding.FragmentInformationBinding;
import com.tkid.eastmoney.ui.activity.AppDebugActivity;
import com.tkid.eastmoney.ui.activity.CameraXActivity;


public class InformationFragment extends Fragment {

    private FragmentInformationBinding mBinding;

    int selectPager = 0;
    FragmentPagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentInformationBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPagerAdapter = new FragmentPagerAdapter(getActivity());
        mPagerAdapter.addFragment(new BuyFragment(),"动态");
        mPagerAdapter.addFragment(new SellFragment(),"要闻");
        mPagerAdapter.addFragment(new RevokeFragment(), "热点");
        mPagerAdapter.addFragment(new CommissionedFragment(), "自选");
        mPagerAdapter.addFragment(new InventoryFragment(), "关注");
        mPagerAdapter.addFragment(new InventoryFragment(), "7x24");
        mBinding.viewpagerInfor.setAdapter(mPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，一个动另一个也会跟着动
        mBinding.tablayoutInfor.setTabTextColors(getActivity().getColor(R.color.black), getActivity().getColor(R.color.orange_bg2));
        mBinding.tablayoutInfor.setSelectedTabIndicatorColor(getActivity().getColor(R.color.orange_bg2));
        mBinding.tablayoutInfor.setTabMode(TabLayout.MODE_FIXED);
        mBinding.tablayoutInfor.setTabIndicatorFullWidth(true);
        mBinding.viewpagerInfor.setCurrentItem(selectPager);
        mBinding.tablayoutInfor.setupWithViewPager(mBinding.viewpagerInfor);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}