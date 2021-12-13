package com.tkid.appsdk.toastutils.style;

import android.content.Context;
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
@SuppressWarnings("unused")
public class LocationToastStyle implements IToastStyle<View> {

    private final IToastStyle<?> mStyle;

    private final int mGravity;
    private final int mXOffset;
    private final int mYOffset;
    private final float mHorizontalMargin;
    private final float mVerticalMargin;

    public LocationToastStyle(IToastStyle<?> style, int gravity) {
        this(style, gravity, 0, 0, 0, 0);
    }

    public LocationToastStyle(IToastStyle<?> style, int gravity, int xOffset, int yOffset, float horizontalMargin, float verticalMargin) {
        mStyle = style;
        mGravity = gravity;
        mXOffset = xOffset;
        mYOffset = yOffset;
        mHorizontalMargin = horizontalMargin;
        mVerticalMargin = verticalMargin;
    }

    @Override
    public View createView(Context context) {
        return mStyle.createView(context);
    }

    @Override
    public int getGravity() {
        return mGravity;
    }

    @Override
    public int getXOffset() {
        return mXOffset;
    }

    @Override
    public int getYOffset() {
        return mYOffset;
    }

    @Override
    public float getHorizontalMargin() {
        return mHorizontalMargin;
    }

    @Override
    public float getVerticalMargin() {
        return mVerticalMargin;
    }
}
