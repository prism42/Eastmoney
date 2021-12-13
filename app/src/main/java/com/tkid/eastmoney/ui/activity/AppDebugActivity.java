package com.tkid.eastmoney.ui.activity;


import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.hjq.shape.view.ShapeEditText;
import com.hjq.shape.view.ShapeTextView;
import com.jaeger.library.StatusBarUtil;
import com.tencent.mmkv.MMKV;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.app.AppActivity;
import com.tkid.eastmoney.model.StockRecordTable;

import org.litepal.LitePal;

import java.util.List;

public class AppDebugActivity extends AppCompatActivity {

    MMKV kv;

    private ShapeEditText setDebugTotalAssets;
    private ShapeEditText setDebugStockName;
    private ShapeEditText setDebugStockCode;
    private ShapeEditText setDebugOpeningPrice;
    private ShapeEditText setDebugClosingPrice;
    private ShapeEditText setDebugCurrentPrice;
    private ShapeEditText setDebugCostPrice;
    private ShapeEditText setDebugPosition;
    private ShapeTextView tvDebugUpdate;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_debug);
        StatusBarUtil.setColor(AppDebugActivity.this, getColor(R.color.orange_bg2));
        StatusBarUtil.setTransparent(AppDebugActivity.this);
        initView();
        initData();
    }

    private void initView() {
        kv = MMKV.defaultMMKV();
        setDebugTotalAssets = findViewById(R.id.set_debug_total_assets);
        setDebugStockName = findViewById(R.id.set_debug_stock_name);
        setDebugStockCode = findViewById(R.id.set_debug_stock_code);
        setDebugOpeningPrice = findViewById(R.id.set_debug_opening_price);
        setDebugClosingPrice = findViewById(R.id.set_debug_closing_price);
        setDebugCurrentPrice = findViewById(R.id.set_debug_current_price);
        setDebugCostPrice = findViewById(R.id.set_debug_cost_price);
        setDebugPosition = findViewById(R.id.set_debug_position);
        tvDebugUpdate = findViewById(R.id.tv_debug_update);
        tvDebugUpdate.setOnClickListener(view -> {
            String totalAssetsStr = setDebugTotalAssets.getText().toString();
            double totalAssets = Double.valueOf(TextUtils.isEmpty(totalAssetsStr)?"0.0":totalAssetsStr);
            String stockName = setDebugStockName.getText().toString();
            String stockCode = setDebugStockCode.getText().toString();
            String openingPriceStr = setDebugOpeningPrice.getText().toString();
            double openingPrice = Double.valueOf(TextUtils.isEmpty(openingPriceStr)?"0.0":openingPriceStr);
            String closingPriceStr = setDebugClosingPrice.getText().toString();
            double closingPrice = Double.valueOf(TextUtils.isEmpty(closingPriceStr)?"0.0":closingPriceStr);
            String currentPriceStr = setDebugCurrentPrice.getText().toString();
            double currentPrice = Double.valueOf(TextUtils.isEmpty(currentPriceStr)?"0.0":currentPriceStr);
            String costPriceStr = setDebugCostPrice.getText().toString();
            double costPrice = Double.valueOf(TextUtils.isEmpty(costPriceStr)?"0.0":costPriceStr);
            String takePositionStr = setDebugPosition.getText().toString();
            int takePosition = Integer.valueOf(TextUtils.isEmpty(takePositionStr)?"0":takePositionStr);
            StockRecordTable stockRecordTable = LitePal.where("stockCode=?",stockCode).findFirst(StockRecordTable.class);

            double marketValue = currentPrice*takePosition;
            double theProfitAndLossPrice = (currentPrice-costPrice)*takePosition;
            double tpalPercent = theProfitAndLossPrice/marketValue*100;
            double currentProfitAndLoss = (currentPrice-closingPrice)*takePosition;
            double cpalPercent = (currentPrice-closingPrice)/closingPrice*100;
            double individualPositions = currentPrice*takePosition/totalAssets*100;

            if(stockRecordTable==null){
                stockRecordTable = new StockRecordTable();
                stockRecordTable.setStockName(stockName);
                stockRecordTable.setStockCode(stockCode);
                stockRecordTable.setMarketValue(marketValue);
                stockRecordTable.setAvailableAmount(takePosition);
                stockRecordTable.setTakePosition(takePosition);
                stockRecordTable.setPresentPrice(currentPrice);
                stockRecordTable.setCostPrice(costPrice);
                stockRecordTable.setTheProfitAndLossPrice(theProfitAndLossPrice);
                stockRecordTable.setTpalPercent(tpalPercent);
                stockRecordTable.setCurrentProfitAndLoss(currentProfitAndLoss);
                stockRecordTable.setCpalPercent(cpalPercent);
                stockRecordTable.setIndividualPositions(individualPositions);
                stockRecordTable.save();
            }else{
                stockRecordTable.setStockName(stockName);
                stockRecordTable.setStockCode(stockCode);
                stockRecordTable.setMarketValue(marketValue);
                stockRecordTable.setAvailableAmount(takePosition);
                stockRecordTable.setTakePosition(takePosition);
                stockRecordTable.setPresentPrice(currentPrice);
                stockRecordTable.setCostPrice(costPrice);
                stockRecordTable.setTheProfitAndLossPrice(theProfitAndLossPrice);
                stockRecordTable.setTpalPercent(tpalPercent);
                stockRecordTable.setCurrentProfitAndLoss(currentProfitAndLoss);
                stockRecordTable.setCpalPercent(cpalPercent);
                stockRecordTable.setIndividualPositions(individualPositions);
                stockRecordTable.update(stockRecordTable.getId());
            }
            kv.encode("TOTAL_ASSETS",totalAssets);
            kv.encode("STOCK_NAME",stockName);
            kv.encode("STOCK_CODE",stockCode);
            kv.encode("OPENING_PRICE",openingPrice);
            kv.encode("CLOSING_PRICE",closingPrice);
            kv.encode("CURRENT_PRICE",currentPrice);
            kv.encode("COST_PRICE",costPrice);
            kv.encode("POSITION",takePosition);
            finish();
        });
    }

    private void initData() {
        double totalAssets = kv.decodeDouble("TOTAL_ASSETS",0.0);
        String stockName = kv.decodeString("STOCK_NAME");
        String stockCode = kv.decodeString("STOCK_CODE");
        double openingPrice = kv.decodeDouble("OPENING_PRICE",0.0);
        double closingPrice = kv.decodeDouble("CLOSING_PRICE",0.0);
        double currentPrice = kv.decodeDouble("CURRENT_PRICE",0.0);
        double costPrice = kv.decodeDouble("COST_PRICE",0.0);
        int takePosition = kv.decodeInt("TAKE_Position",0);
        setDebugTotalAssets.setText(String.format("%.2f",totalAssets));
        setDebugStockName.setText(stockName);
        setDebugStockCode.setText(stockCode);
        setDebugOpeningPrice.setText(String.format("%.2f",openingPrice));
        setDebugClosingPrice.setText(String.format("%.2f",closingPrice));
        setDebugCurrentPrice.setText(String.format("%.2f",currentPrice));
        setDebugCostPrice.setText(String.format("%.2f",costPrice));
        setDebugPosition.setText(String.valueOf(takePosition));
    }
}