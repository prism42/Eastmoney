package com.tkid.eastmoney.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.tkid.eastmoney.R;
import com.tkid.eastmoney.constant.Constant;

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
public class BottomControlPanel extends LinearLayout implements View.OnClickListener {

    private Context mContext;
    private ImageText mHomeBtn = null;
    private ImageText mInformationBtn = null;
    private ImageText mOptionalBtn = null;
    private ImageText mMarketBtn = null;
    private ImageText mTradingBtn = null;
    private int DEAFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243);
    private BottomPanelCallback mBottomCallback = null;
    private List<ImageText> viewList = new ArrayList<ImageText>();

    public interface BottomPanelCallback {
        public void onBottomPanleClick(int itemID);
    }

    public BottomControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        setOrientation(HORIZONTAL);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mHomeBtn = (ImageText) findViewById(R.id.btn_home);
        mInformationBtn = (ImageText) findViewById(R.id.btn_information);
        mOptionalBtn = (ImageText) findViewById(R.id.btn_optional);
        mMarketBtn = (ImageText) findViewById(R.id.btn_market);
        mTradingBtn = (ImageText) findViewById(R.id.btn_trading);
        setBackgroundColor(DEAFALUT_BACKGROUND_COLOR);
        viewList.add(mHomeBtn);
        viewList.add(mInformationBtn);
        viewList.add(mOptionalBtn);
        viewList.add(mMarketBtn);
        viewList.add(mTradingBtn);
    }

    public void initBottomPanel() {
        if (mHomeBtn != null) {
            mHomeBtn.setImage(R.drawable.boy_whitemode);
            mHomeBtn.setText(Constant.FRAGMENT_FLAG_HOME);
        }
        if (mInformationBtn != null) {
            mInformationBtn.setImage(R.drawable.bp3_whitemode);
            mInformationBtn.setText(Constant.FRAGMENT_FLAG_INFORMATION);
        }
        if (mOptionalBtn != null) {
            mOptionalBtn.setImage(R.drawable.bp5_whitemode);
            mOptionalBtn.setText(Constant.FRAGMENT_FLAG_OPTIONAL);
        }
        if (mMarketBtn != null) {
            mMarketBtn.setImage(R.drawable.bp1_whitemode);
            mMarketBtn.setText(Constant.FRAGMENT_FLAG_MARKET);
        }
        if (mTradingBtn != null) {
            mTradingBtn.setImage(R.drawable.bp7_whitemode);
            mTradingBtn.setText(Constant.FRAGMENT_FLAG_TRADING);
        }
        setButtonListener();
    }

    private void setButtonListener() {
        int num = this.getChildCount();
        for (int i = 0; i < num; i++) {
            View v = getChildAt(i);
            if (v != null) {
                v.setOnClickListener(this);
            }
        }
    }

    public void setBottonCallback(BottomPanelCallback bottomCallback) {
        mBottomCallback = bottomCallback;
    }

    @Override
    public void onClick(View v) {
        initBottomPanel();
        int index = -1;
        switch (v.getId()) {
            case R.id.btn_home:
                index = Constant.BTN_FLAG_HOME;
                mHomeBtn.setChecked(Constant.BTN_FLAG_HOME);
                break;
            case R.id.btn_information:
                index = Constant.BTN_FLAG_INFORMATION;
                mInformationBtn.setChecked(Constant.BTN_FLAG_INFORMATION);
                break;
            case R.id.btn_optional:
                index = Constant.BTN_FLAG_OPTIONAL;
                mOptionalBtn.setChecked(Constant.BTN_FLAG_OPTIONAL);
                break;
            case R.id.btn_market:
                index = Constant.BTN_FLAG_MARKET;
                mMarketBtn.setChecked(Constant.BTN_FLAG_MARKET);
                break;
            case R.id.btn_trading:
                index = Constant.BTN_FLAG_TRADING;
                mTradingBtn.setChecked(Constant.BTN_FLAG_TRADING);
                break;
            default:
                break;
        }
        if(mBottomCallback!=null){
            mBottomCallback.onBottomPanleClick(index);
        }

    }
    public void defaultButtonChecked(){
        if(mHomeBtn!=null){
            mHomeBtn.setChecked(Constant.BTN_FLAG_HOME);
        }
    }
    @Override
    public void onLayout(boolean changed, int left, int top, int right, int bottom){
        super.onLayout(changed, left, top, right, bottom);
        layoutItems(left,top,right,bottom);
    }

    private void layoutItems(int left, int top, int right, int bottom) {
        int n=getChildCount();
        if(n==0){
            return;
        }
        int paddingLeft=getPaddingLeft();
        int paddingRight=getPaddingRight();
        int width=right-left;
        int height=bottom-top;
        int allWidth=0;
        for(int i=0;i<n;i++){
            View v=getChildAt(i);
            allWidth+=v.getWidth();
        }
        int blankWidth=(width-allWidth-paddingLeft-paddingRight)/(n-1);

        LayoutParams params1=(LayoutParams) viewList.get(1).getLayoutParams();
        params1.leftMargin=blankWidth;
        viewList.get(1).setLayoutParams(params1);

        LayoutParams params2=(LayoutParams) viewList.get(2).getLayoutParams();
        params2.leftMargin=blankWidth;
        viewList.get(2).setLayoutParams(params2);
    }
}
