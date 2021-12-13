package com.tkid.eastmoney.ui.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tkid.eastmoney.databinding.FragmentTradingBinding;
import com.tkid.eastmoney.ui.activity.CashHoldingsActivity;
import com.tkid.eastmoney.ui.activity.TradingActivity;


public class TradingFragment extends Fragment {

   private FragmentTradingBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentTradingBinding.inflate(inflater,container,false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBinding.rlTradingGridBuy.setOnClickListener(view14 -> startActivity(new Intent(getActivity(), TradingActivity.class).putExtra("VIEWPAGER",0)));

        mBinding.rlTradingGridSell.setOnClickListener(view13 -> startActivity(new Intent(getActivity(), TradingActivity.class).putExtra("VIEWPAGER",1)));

        mBinding.rlTradingGridCancel.setOnClickListener(view12 -> startActivity(new Intent(getActivity(), TradingActivity.class).putExtra("VIEWPAGER",2)));

        mBinding.rlTradingGridOptionsHold.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), TradingActivity.class).putExtra("VIEWPAGER",4));
//                startActivity(new Intent(getActivity(), CashHoldingsActivity.class));
        });

        mBinding.rlTradingGridCreditEntrustdeal.setOnClickListener(view15 -> startActivity(new Intent(getActivity(), TradingActivity.class).putExtra("VIEWPAGER",3)));

        mBinding.rlTradingGridNewstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBinding.rlTradingGridOptionsYyzz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        mBinding.rlTradingGridCreditMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }
}