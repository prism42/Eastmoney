package com.tkid.appsdk.toastutils.style;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.tkid.appsdk.toastutils.config.IToastStyle;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ViewToastStyle implements IToastStyle<View> {

    private final int mLayoutId;
    private final IToastStyle<?> mStyle;

    public ViewToastStyle(int id, IToastStyle<?> style) {
        mLayoutId = id;
        mStyle = style;
    }

    @Override
    public View createView(Context context) {
        return LayoutInflater.from(context).inflate(mLayoutId, null);
    }

    @Override
    public int getGravity() {
        if (mStyle == null) {
            return Gravity.CENTER;
        }
        return mStyle.getGravity();
    }

    @Override
    public int getXOffset() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getXOffset();
    }

    @Override
    public int getYOffset() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getYOffset();
    }

    @Override
    public float getHorizontalMargin() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getHorizontalMargin();
    }

    @Override
    public float getVerticalMargin() {
        if (mStyle == null) {
            return 0;
        }
        return mStyle.getVerticalMargin();
    }
}
