package com.tkid.eastmoney.model;

import org.litepal.crud.LitePalSupport;

import java.util.Date;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class StockRecordTable extends LitePalSupport {

    int id;
    //股票代码
    String stockCode;
    //股票名称
    String stockName;
    //市值
    double marketValue;
    //持仓
    int takePosition;
    //可用
    int availableAmount;
    //现价
    double presentPrice;
    //成本
    double costPrice;
    //持仓盈亏
    double theProfitAndLossPrice;
    //持仓盈亏比
    double tpalPercent;
    //当日盈亏
    double currentProfitAndLoss;
    //当日盈亏比
    double cpalPercent;
    //个股仓位
    double individualPositions;
    //股票日期
    Date currentDate;
    //总资产
    double totalAssets;
    String extension;
    String extension1;
    String extension2;
    int nExtension;
    int nExtension2;
    int nExtension3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }

    public int getTakePosition() {
        return takePosition;
    }

    public void setTakePosition(int takePosition) {
        this.takePosition = takePosition;
    }

    public int getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(int availableAmount) {
        this.availableAmount = availableAmount;
    }

    public double getPresentPrice() {
        return presentPrice;
    }

    public void setPresentPrice(double presentPrice) {
        this.presentPrice = presentPrice;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getTheProfitAndLossPrice() {
        return theProfitAndLossPrice;
    }

    public void setTheProfitAndLossPrice(double theProfitAndLossPrice) {
        this.theProfitAndLossPrice = theProfitAndLossPrice;
    }

    public double getTpalPercent() {
        return tpalPercent;
    }

    public void setTpalPercent(double tpalPercent) {
        this.tpalPercent = tpalPercent;
    }

    public double getCurrentProfitAndLoss() {
        return currentProfitAndLoss;
    }

    public void setCurrentProfitAndLoss(double currentProfitAndLoss) {
        this.currentProfitAndLoss = currentProfitAndLoss;
    }

    public double getCpalPercent() {
        return cpalPercent;
    }

    public void setCpalPercent(double cpalPercent) {
        this.cpalPercent = cpalPercent;
    }

    public double getIndividualPositions() {
        return individualPositions;
    }

    public void setIndividualPositions(double individualPositions) {
        this.individualPositions = individualPositions;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getExtension1() {
        return extension1;
    }

    public void setExtension1(String extension1) {
        this.extension1 = extension1;
    }

    public String getExtension2() {
        return extension2;
    }

    public void setExtension2(String extension2) {
        this.extension2 = extension2;
    }

    public int getnExtension() {
        return nExtension;
    }

    public void setnExtension(int nExtension) {
        this.nExtension = nExtension;
    }

    public int getnExtension2() {
        return nExtension2;
    }

    public void setnExtension2(int nExtension2) {
        this.nExtension2 = nExtension2;
    }

    public int getnExtension3() {
        return nExtension3;
    }

    public void setnExtension3(int nExtension3) {
        this.nExtension3 = nExtension3;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }
}
