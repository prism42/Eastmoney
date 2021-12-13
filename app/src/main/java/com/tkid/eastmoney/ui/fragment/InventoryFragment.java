package com.tkid.eastmoney.ui.fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tencent.mmkv.MMKV;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.adapter.StocksAdapter;
import com.tkid.eastmoney.model.StockRecordTable;
import com.tkid.eastmoney.widget.HSRecyclerView;
import com.tkid.eastmoney.widget.ObserverHScrollView;

import org.litepal.LitePal;

import java.util.List;

public class InventoryFragment extends Fragment {

    LinearLayout mScrollTitleContainer;
    ObserverHScrollView mHeadTitleScrollView;
    HSRecyclerView mContentRlv;
    private TextView tvCashHoldingsCount;
    private TextView tvItemHeadSecuritiesMarketValue;
    List<StockRecordTable> mStockRecordTables;
    private TextView tvCashHoldingsTotalAssets;
    private TextView tvCashHoldingsTheProfitAndLossPrice;
    private TextView tvCashHoldingsAvailableAmount;
    private TextView tvCashHoldingsTotalMarketValue;
    private TextView tvCashHoldingsCurrentProfitAndLoss;
    private TextView tvCashHoldingsDesirableAmount;
    MMKV kv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        initData();
    }

    private void initData() {
        double totalAssets = kv.decodeDouble("TOTAL_ASSETS",0.0);
        double totalMarketValue = 0;
        double totalTheProfitAndLossPrice = 0;
        double totalCurrentProfitAndLoss = 0;
        for (int i = 0; i < mStockRecordTables.size(); i++) {
            totalMarketValue += mStockRecordTables.get(i).getMarketValue();
            totalTheProfitAndLossPrice += mStockRecordTables.get(i).getTheProfitAndLossPrice();
            totalCurrentProfitAndLoss += mStockRecordTables.get(i).getCurrentProfitAndLoss();
        }
        if(totalTheProfitAndLossPrice>0){
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(getActivity(),R.color.red_ying));
        }else if(totalTheProfitAndLossPrice<0){
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(getActivity(),R.color.green_kui));
        }else{
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(getActivity(),R.color.black));
        }
        if(totalCurrentProfitAndLoss>0){
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(),R.color.red_ying));
        }else if(totalCurrentProfitAndLoss<0){
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(),R.color.green_kui));
        }else{
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(getActivity(),R.color.black));
        }
        double totalAvailableAmount = totalAssets - totalMarketValue;
        double totalDesirableAmount = totalAssets - totalMarketValue;
        tvCashHoldingsTotalAssets.setText(String.format("%.2f",totalAssets));
        tvCashHoldingsTheProfitAndLossPrice.setText(String.format("%.2f",totalTheProfitAndLossPrice));
        tvCashHoldingsAvailableAmount.setText(String.format("%.2f",totalAvailableAmount));
        tvCashHoldingsTotalMarketValue.setText(String.format("%.2f",totalMarketValue));
        tvCashHoldingsCurrentProfitAndLoss.setText(String.format("%.2f",totalCurrentProfitAndLoss));
        tvCashHoldingsDesirableAmount.setText(String.format("%.2f",totalDesirableAmount));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initUI(View view) {
        kv = MMKV.defaultMMKV();
        mStockRecordTables = LitePal.findAll(StockRecordTable.class);

        tvCashHoldingsTotalAssets = view.findViewById(R.id.tv_cash_holdings_total_assets);
        tvCashHoldingsTheProfitAndLossPrice = view.findViewById(R.id.tv_cash_holdings_the_profit_and_loss_price);
        tvCashHoldingsAvailableAmount = view.findViewById(R.id.tv_cash_holdings_available_amount);
        tvCashHoldingsTotalMarketValue = view.findViewById(R.id.tv_cash_holdings_total_market_value);
        tvCashHoldingsCurrentProfitAndLoss = view.findViewById(R.id.tv_cash_holdings_current_profit_and_loss);
        tvCashHoldingsDesirableAmount = view.findViewById(R.id.tv_cash_holdings_desirable_amount);

        tvItemHeadSecuritiesMarketValue = view.findViewById(R.id.tv_item_head_securities_market_value);
        tvCashHoldingsCount = view.findViewById(R.id.tv_cash_holdings_count);
        mScrollTitleContainer = view.findViewById(R.id.scroll_title_container);
        mHeadTitleScrollView = view.findViewById(R.id.head_title_scroll_view);
        mContentRlv = view.findViewById(R.id.content_rlv);

        tvItemHeadSecuritiesMarketValue.setText(Html.fromHtml("<font color='#000000'>证券</font><font color='#989898'>/市值</font>",Html.FROM_HTML_MODE_COMPACT));
        String[] titles = new String[]{"持仓/可用", "现价/成本", "持仓盈亏", "当日盈亏", "个股仓位", "证券代码"};

        for (int i = 0; i < titles.length; i++) {
            View singleTitleLayout = View.inflate(getActivity(), R.layout.item_cash_holdings_title, null);
            ((TextView) singleTitleLayout.findViewById(R.id.title_tv)).setText(titles[i]);
            mScrollTitleContainer.addView(singleTitleLayout);
        }

        mContentRlv.setHasFixedSize(true);
        mContentRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //rlv和header关联
        StocksAdapter stockAdapter = new StocksAdapter(getActivity(),mHeadTitleScrollView);
        mContentRlv.setAdapter(stockAdapter);
        stockAdapter.setData(mStockRecordTables);
        //rlv和header关联，rlv滑動時讓header跟隨
        mContentRlv.setHorizontalScrollView(mHeadTitleScrollView);
        tvCashHoldingsCount.setText("共有" + mStockRecordTables.size() + "条持仓记录");
    }
}