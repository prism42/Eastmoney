package com.tkid.eastmoney.ui.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.tencent.mmkv.MMKV;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.adapter.StocksAdapter;
import com.tkid.eastmoney.model.StockRecordTable;
import com.tkid.eastmoney.widget.HSRecyclerView;
import com.tkid.eastmoney.widget.ObserverHScrollView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;

public class CashHoldingsActivity extends AppCompatActivity {

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


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_holdings);
        StatusBarUtil.setColor(CashHoldingsActivity.this, getColor(R.color.orange_bg2));
        StatusBarUtil.setTransparent(CashHoldingsActivity.this);
        initUI();
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
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(this,R.color.red_ying));
        }else if(totalTheProfitAndLossPrice<0){
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(this,R.color.green_kui));
        }else{
            tvCashHoldingsTheProfitAndLossPrice.setTextColor(ContextCompat.getColor(this,R.color.black));
        }
        if(totalCurrentProfitAndLoss>0){
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(this,R.color.red_ying));
        }else if(totalCurrentProfitAndLoss<0){
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(this,R.color.green_kui));
        }else{
            tvCashHoldingsCurrentProfitAndLoss.setTextColor(ContextCompat.getColor(this,R.color.black));
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
    private void initUI() {
        kv = MMKV.defaultMMKV();
        mStockRecordTables = LitePal.findAll(StockRecordTable.class);

        tvCashHoldingsTotalAssets = findViewById(R.id.tv_cash_holdings_total_assets);
        tvCashHoldingsTheProfitAndLossPrice = findViewById(R.id.tv_cash_holdings_the_profit_and_loss_price);
        tvCashHoldingsAvailableAmount = findViewById(R.id.tv_cash_holdings_available_amount);
        tvCashHoldingsTotalMarketValue = findViewById(R.id.tv_cash_holdings_total_market_value);
        tvCashHoldingsCurrentProfitAndLoss = findViewById(R.id.tv_cash_holdings_current_profit_and_loss);
        tvCashHoldingsDesirableAmount = findViewById(R.id.tv_cash_holdings_desirable_amount);

        tvItemHeadSecuritiesMarketValue = findViewById(R.id.tv_item_head_securities_market_value);
        tvCashHoldingsCount = findViewById(R.id.tv_cash_holdings_count);
        mScrollTitleContainer = findViewById(R.id.scroll_title_container);
        mHeadTitleScrollView = findViewById(R.id.head_title_scroll_view);
        mContentRlv = findViewById(R.id.content_rlv);

        tvItemHeadSecuritiesMarketValue.setText(Html.fromHtml("<font color='#000000'>证券</font><font color='#989898'>/市值</font>",Html.FROM_HTML_MODE_COMPACT));
        String[] titles = new String[]{"持仓/可用", "现价/成本", "持仓盈亏", "当日盈亏", "个股仓位", "证券代码"};

        for (int i = 0; i < titles.length; i++) {
            View singleTitleLayout = View.inflate(this, R.layout.item_cash_holdings_title, null);
            ((TextView) singleTitleLayout.findViewById(R.id.title_tv)).setText(titles[i]);
            mScrollTitleContainer.addView(singleTitleLayout);
        }

        mContentRlv.setHasFixedSize(true);
        mContentRlv.setLayoutManager(new LinearLayoutManager(this));
        //rlv和header关联
        StocksAdapter stockAdapter = new StocksAdapter(this,mHeadTitleScrollView);
        mContentRlv.setAdapter(stockAdapter);

//        List<StockRecordTable> equiteEntities = new ArrayList<>();
//        for (int i = 0; i < 1; i++) {
//            StockRecordTable stockRecordTable = new StockRecordTable();
//            stockRecordTable.setStockName("天海防务");
//            stockRecordTable.setStockCode("300008");
////            double totalAssets = 62059.4;
//            double totalAssets = 131029.7;
//            int takePosition = 10000;
//            int availableAmount = 10000;
//            double presentPrice = 4.66;
//            double costPrice = 5.231;
//            double marketValue = presentPrice*takePosition;
//            double theProfitAndLossPrice = (presentPrice-costPrice)*takePosition;
//            double tpalPercent = theProfitAndLossPrice/marketValue*100;
//            double currentProfitAndLoss = -450;
//            double cpalPercent = -1.895;
//            double individualPositions = presentPrice*takePosition/totalAssets*100;
//            stockRecordTable.setMarketValue(marketValue);
//            stockRecordTable.setTakePosition(takePosition);
//            stockRecordTable.setAvailableAmount(availableAmount);
//            stockRecordTable.setPresentPrice(presentPrice);
//            stockRecordTable.setCostPrice(costPrice);
//            stockRecordTable.setTheProfitAndLossPrice(theProfitAndLossPrice);
//            stockRecordTable.setTpalPercent(tpalPercent);
//            stockRecordTable.setCurrentProfitAndLoss(currentProfitAndLoss);
//            stockRecordTable.setCpalPercent(cpalPercent);
//            stockRecordTable.setIndividualPositions(individualPositions);
//            equiteEntities.add(stockRecordTable);
//        }
        stockAdapter.setData(mStockRecordTables);
        //rlv和header关联，rlv滑動時讓header跟隨
        mContentRlv.setHorizontalScrollView(mHeadTitleScrollView);
        tvCashHoldingsCount.setText("共有" + mStockRecordTables.size() + "条持仓记录");
    }
}