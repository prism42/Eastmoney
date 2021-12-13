package com.tkid.eastmoney.ui.fragment;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.tkid.appsdk.base.FragmentPagerAdapter;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.databinding.FragmentHomeBinding;
import com.tkid.eastmoney.model.DataBean;
import com.youth.banner.adapter.BannerAdapter;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.config.BannerConfig;
import com.youth.banner.holder.BannerImageHolder;
import com.youth.banner.indicator.CircleIndicator;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Transformer;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    int selectPager = 0;
    FragmentPagerAdapter mPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initBanner();
        return binding.getRoot();

    }

    private void initBanner() {

        //设置数据
        List<String> list = new ArrayList<>();

        list.add("加入私募菁英计划");
        list.add("2021年股市成语征集令");
        list.add("百度发布元宇宙产品");
        list.add("借基布局新能源车强赛道");
        list.add("北资本周净买入创纪录");
        list.add("2021年股市成语征集令");
        list.add("禛瑛投资年度新品路演");
        list.add("百度发布元宇宙产品");
        list.add("北资本周净买入创纪录");

//调用setDatas(List<String>)方法后,TextBannerView自动开始轮播
//注意：此方法目前只接受List<String>类型
        binding.tvBanner.setDatas(list);

        binding.banner.setAdapter(new BannerImageAdapter<DataBean>(DataBean.getTestData3()) {
            @Override
            public void onBindView(BannerImageHolder holder, DataBean data, int position, int size) {
                //图片加载自己实现
                Glide.with(holder.itemView)
                        .load(data.imageUrl)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(holder.imageView);
            }
        }).addBannerLifecycleObserver(this)//添加生命周期观察者
         .setIndicator(new CircleIndicator(getActivity()));
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
        binding.viewpager.setAdapter(mPagerAdapter);
        //将TabLayout和ViewPager绑定在一起，一个动另一个也会跟着动
        binding.tablayout.setTabTextColors(getActivity().getColor(R.color.black), getActivity().getColor(R.color.orange_bg2));
        binding.tablayout.setSelectedTabIndicatorColor(getActivity().getColor(R.color.orange_bg2));
        binding.tablayout.setTabMode(TabLayout.MODE_FIXED);
        binding.tablayout.setTabIndicatorFullWidth(true);
        binding.viewpager.setCurrentItem(selectPager);
        binding.tablayout.setupWithViewPager(binding.viewpager);
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.tvBanner.startViewAnimator();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        binding.tvBanner.stopViewAnimator();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}