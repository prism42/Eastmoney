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
public class TransactionRecordTable extends LitePalSupport {

    int id;
    //股票代码
    String stockCode;
    //股票名称
    String stockName;
    //买卖类型，1 买入 0 卖出
    int businessType;
    //买入价格
    double buyingPrice;
    //卖出价格
    double sellingPrice;
    //委托价格
    double entrustThePrice;
    //成交价格
    double clinchADealThePrice;
    //交易次数
    int transactionNumber;
    //买入次数
    int buyNumber;
    //卖出次数
    int sellNumber;
    //交易日期
    Date transactionDate;
    //持有
    int holdings;
    //总资产
    double totalAssets;
    //总市值
    double totalMarketValue;
    //持仓盈亏
    double theProfitAndLossPrice;
    //当日盈亏
    double currentProfitAndLoss;
    //持仓盈亏百分比
    double tpalPercent;
    //当日盈亏百分比
    double cpalPercent;
    //可用
    double availableAmount;
    //可取
    double desirableAmount;
    //现价
    double presentPrice;
    //成本
    double costPrice;
    //个股仓位百分比
    double individualPositions;
    //统计日期
    Date statisticalDate;
    //时间戳1
    long timeStamp1;
    //时间戳2
    long timeStamp2;
    //股票日期
    Date currentDate;
    //委价
    double entrustPrice;
    //均价
    double averagePrice;
    //委量
    int entrustNumber;
    //成交
    int clinchADealNumber;
    //方向
    int businessDirection;
    //状态 0已报 1已成
    int businessState;
    //扩展
    String extension;

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

    public int getBusinessType() {
        return businessType;
    }

    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getEntrustThePrice() {
        return entrustThePrice;
    }

    public void setEntrustThePrice(double entrustThePrice) {
        this.entrustThePrice = entrustThePrice;
    }

    public double getClinchADealThePrice() {
        return clinchADealThePrice;
    }

    public void setClinchADealThePrice(double clinchADealThePrice) {
        this.clinchADealThePrice = clinchADealThePrice;
    }

    public int getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }

    public int getSellNumber() {
        return sellNumber;
    }

    public void setSellNumber(int sellNumber) {
        this.sellNumber = sellNumber;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public int getHoldings() {
        return holdings;
    }

    public void setHoldings(int holdings) {
        this.holdings = holdings;
    }

    public double getTotalAssets() {
        return totalAssets;
    }

    public void setTotalAssets(double totalAssets) {
        this.totalAssets = totalAssets;
    }

    public double getTotalMarketValue() {
        return totalMarketValue;
    }

    public void setTotalMarketValue(double totalMarketValue) {
        this.totalMarketValue = totalMarketValue;
    }

    public double getTheProfitAndLossPrice() {
        return theProfitAndLossPrice;
    }

    public void setTheProfitAndLossPrice(double theProfitAndLossPrice) {
        this.theProfitAndLossPrice = theProfitAndLossPrice;
    }

    public double getCurrentProfitAndLoss() {
        return currentProfitAndLoss;
    }

    public void setCurrentProfitAndLoss(double currentProfitAndLoss) {
        this.currentProfitAndLoss = currentProfitAndLoss;
    }

    public double getTpalPercent() {
        return tpalPercent;
    }

    public void setTpalPercent(double tpalPercent) {
        this.tpalPercent = tpalPercent;
    }

    public double getCpalPercent() {
        return cpalPercent;
    }

    public void setCpalPercent(double cpalPercent) {
        this.cpalPercent = cpalPercent;
    }

    public double getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(double availableAmount) {
        this.availableAmount = availableAmount;
    }

    public double getDesirableAmount() {
        return desirableAmount;
    }

    public void setDesirableAmount(double desirableAmount) {
        this.desirableAmount = desirableAmount;
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

    public double getIndividualPositions() {
        return individualPositions;
    }

    public void setIndividualPositions(double individualPositions) {
        this.individualPositions = individualPositions;
    }

    public Date getStatisticalDate() {
        return statisticalDate;
    }

    public void setStatisticalDate(Date statisticalDate) {
        this.statisticalDate = statisticalDate;
    }

    public long getTimeStamp1() {
        return timeStamp1;
    }

    public void setTimeStamp1(long timeStamp1) {
        this.timeStamp1 = timeStamp1;
    }

    public long getTimeStamp2() {
        return timeStamp2;
    }

    public void setTimeStamp2(long timeStamp2) {
        this.timeStamp2 = timeStamp2;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public double getEntrustPrice() {
        return entrustPrice;
    }

    public void setEntrustPrice(double entrustPrice) {
        this.entrustPrice = entrustPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public int getEntrustNumber() {
        return entrustNumber;
    }

    public void setEntrustNumber(int entrustNumber) {
        this.entrustNumber = entrustNumber;
    }

    public int getClinchADealNumber() {
        return clinchADealNumber;
    }

    public void setClinchADealNumber(int clinchADealNumber) {
        this.clinchADealNumber = clinchADealNumber;
    }

    public int getBusinessDirection() {
        return businessDirection;
    }

    public void setBusinessDirection(int businessDirection) {
        this.businessDirection = businessDirection;
    }

    public int getBusinessState() {
        return businessState;
    }

    public void setBusinessState(int businessState) {
        this.businessState = businessState;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
