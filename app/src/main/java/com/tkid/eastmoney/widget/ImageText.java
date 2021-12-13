package com.tkid.eastmoney.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tkid.eastmoney.R;
import com.tkid.eastmoney.constant.Constant;
import com.tkid.eastmoney.util.DensityUtil;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ImageText extends LinearLayout {

    private Context mContext=null;
    private ImageView mImageView=null;
    private TextView mTextView=null;
    private final static int DEAFAULT_IMAGE_WIDTH=24;
    private final static int DEAFAULT_IMAGE_HEIGHT=24;
    private int CHECKED_COLOR= Color.rgb(255,85,0);
    private int UNCHECKED_COLOR=Color.GRAY;
    public ImageText(Context context) {
        super(context);
        mContext=context;
    }
    public ImageText(Context context, AttributeSet attrs){
        super(context,attrs);
        mContext=context;
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parent=inflater.inflate(R.layout.bottom_image_text, this, true);
        mImageView=(ImageView) findViewById(R.id.bottom_image);
        mTextView=(TextView) findViewById(R.id.bottom_text);
    }
    public void setText(String s){
        if(mTextView!=null){
            mTextView.setText(s);
            mTextView.setTextColor(UNCHECKED_COLOR);
        }
    }
    public void setImage(int id){
        if(mImageView!=null){
            mImageView.setImageResource(id);
            //setImageSize(DEAFAULT_IMAGE_WIDTH,DEAFAULT_IMAGE_HEIGHT);
            setImageSize(DensityUtil.dip2px(mContext,DEAFAULT_IMAGE_WIDTH),DensityUtil.dip2px(mContext,DEAFAULT_IMAGE_HEIGHT));

        }
    }
    public void setImageSize(int w,int h){
        if(mImageView!=null){
            LayoutParams params=(LayoutParams) mImageView.getLayoutParams();
            params.width=w;
            params.height=h;
            mImageView.setLayoutParams(params);
        }
    }
    public void setChecked(int itemId){
        if(mTextView!=null){
            mTextView.setTextColor(CHECKED_COLOR);
        }
        int checkDrawableId=-1;
        switch(itemId){
            case Constant.BTN_FLAG_HOME:
                checkDrawableId= R.drawable.boz_whitemode;
                break;
            case Constant.BTN_FLAG_INFORMATION:
                checkDrawableId=R.drawable.bp4_whitemode;
                break;
            case Constant.BTN_FLAG_OPTIONAL:
                checkDrawableId=R.drawable.bp6_whitemode;
                break;
            case Constant.BTN_FLAG_MARKET:
                checkDrawableId=R.drawable.bp2_whitemode;
//                R.drawable.bp7_whitemode
                break;
            case Constant.BTN_FLAG_TRADING:
                checkDrawableId=R.drawable.bp8_whitemode;
//                R.drawable.bp7_whitemode
                break;
            default:
                break;
        }
        if(mImageView!=null){
            mImageView.setImageResource(checkDrawableId);
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
