package com.tkid.eastmoney.adapter;

import android.content.Context;
import android.graphics.Color;
import android.service.controls.templates.ToggleRangeTemplate;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.tkid.eastmoney.R;
import com.tkid.eastmoney.model.StockRecordTable;
import com.tkid.eastmoney.model.TransactionRecordTable;
import com.tkid.eastmoney.widget.ObserverHScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class StocksAdapter extends RecyclerView.Adapter<StocksAdapter.ViewHolder> {

    private ObserverHScrollView mObserverHScrollView;

    private List<StockRecordTable> mEntities;
    Context mContext;

    public StocksAdapter(Context mContext,ObserverHScrollView observerHScrollView) {
        this.mContext = mContext;
        mObserverHScrollView = observerHScrollView;
        mEntities = new ArrayList<>();
    }

    public void setData(List<StockRecordTable> entities) {
        this.mEntities.clear();
        mEntities.addAll(entities);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cash_holdings_value, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        //header和lv关联,header滑動時item跟隨
        mObserverHScrollView.addOnScrollChangedListener(new ObserverHScrollView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int l, int t, int oldl, int oldt) {
                holder.mContentScrollView.smoothScrollTo(l, t);
            }
        });
        StockRecordTable stockRecordTable = mEntities.get(position);
        String stockName = stockRecordTable.getStockName();
        String stockCode = stockRecordTable.getStockCode();
        double marketValue = stockRecordTable.getMarketValue();
        int takePosition = stockRecordTable.getTakePosition();
        int availableAmount = stockRecordTable.getAvailableAmount();
        double presentPrice = stockRecordTable.getPresentPrice();
        double costPrice = stockRecordTable.getCostPrice();
        double theProfitAndLossPrice = stockRecordTable.getTheProfitAndLossPrice();
        double tpalPercent = stockRecordTable.getTpalPercent();
        double currentProfitAndLoss = stockRecordTable.getCurrentProfitAndLoss();
        double cpalPercent = stockRecordTable.getCpalPercent();
        double individualPositions = stockRecordTable.getIndividualPositions();
        holder.mTvStockSecurities.setText(stockName);
        holder.mTvStockMarketValue.setText(String.format("%.2f",marketValue));
        holder.mTvStockOpenPosition.setText(String.valueOf(takePosition));
        holder.mTvStockAvailable.setText(String.valueOf(availableAmount));
        holder.mTvStockCurrentPrice.setText(String.format("%.3f",presentPrice));
        holder.mTvStockCost.setText(String.format("%.3f",costPrice));
        holder.mTvStockOpsitionGainAndLoss.setText(String.format("%.2f",theProfitAndLossPrice));
        holder.mTvStockOpsitionGainAndLossPercent.setText(String.format("%.3f",tpalPercent) + "%");
        if(theProfitAndLossPrice>0){
            holder.mTvStockOpsitionGainAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.red_ying));
            holder.mTvStockOpsitionGainAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.red_ying));
        }else if(theProfitAndLossPrice<0){
            holder.mTvStockOpsitionGainAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.green_kui));
            holder.mTvStockOpsitionGainAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.green_kui));
        }else{
            holder.mTvStockOpsitionGainAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.black));
            holder.mTvStockOpsitionGainAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.black));
        }
        holder.mTvStockProfitAndLoss.setText(String.format("%.2f",currentProfitAndLoss));
        holder.mTvStockProfitAndLossPercent.setText(String.format("%.3f",cpalPercent) + "%");
        if(currentProfitAndLoss>0){
            holder.mTvStockProfitAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.red_ying));
            holder.mTvStockProfitAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.red_ying));
        }else if(currentProfitAndLoss<0){
            holder.mTvStockProfitAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.green_kui));
            holder.mTvStockProfitAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.green_kui));
        }else{
            holder.mTvStockProfitAndLoss.setTextColor(ContextCompat.getColor(mContext,R.color.black));
            holder.mTvStockProfitAndLossPercent.setTextColor(ContextCompat.getColor(mContext,R.color.black));
        }
        holder.mTvStockIndividualPositions.setText(String.format("%.2f",individualPositions) + "%");
        holder.mTvStockCode.setText(stockCode);
    }

    @Override
    public int getItemCount() {
        return mEntities.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvStockSecurities;
        TextView mTvStockMarketValue;
        TextView mTvStockOpenPosition;
        TextView mTvStockAvailable;
        TextView mTvStockCurrentPrice;
        TextView mTvStockCost;
        TextView mTvStockOpsitionGainAndLoss;
        TextView mTvStockOpsitionGainAndLossPercent;
        TextView mTvStockProfitAndLoss;
        TextView mTvStockProfitAndLossPercent;
        TextView mTvStockIndividualPositions;
        TextView mTvStockCode;

        ObserverHScrollView mContentScrollView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvStockSecurities = itemView.findViewById(R.id.tv_stock_securities);
            mTvStockMarketValue = itemView.findViewById(R.id.tv_stock_market_value);
            mTvStockOpenPosition = itemView.findViewById(R.id.tv_stock_open_position);
            mTvStockAvailable = itemView.findViewById(R.id.tv_stock_available);
            mTvStockCurrentPrice = itemView.findViewById(R.id.tv_stock_current_price);
            mTvStockCost = itemView.findViewById(R.id.tv_stock_cost);
            mTvStockOpsitionGainAndLoss = itemView.findViewById(R.id.tv_stock_opsition_gain_and_loss);
            mTvStockOpsitionGainAndLossPercent = itemView.findViewById(R.id.tv_stock_opsition_gain_and_loss_percent);
            mTvStockProfitAndLoss = itemView.findViewById(R.id.tv_stock_profit_and_loss);
            mTvStockProfitAndLossPercent = itemView.findViewById(R.id.tv_stock_profit_and_loss_percent);
            mTvStockIndividualPositions = itemView.findViewById(R.id.tv_stock_individual_positions);
            mTvStockCode = itemView.findViewById(R.id.tv_stock_code);
            mContentScrollView = itemView.findViewById(R.id.content_scroll_view);
        }
    }
}
