package com.tkid.eastmoney.manager.other;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.tkid.appsdk.bar.style.LightBarStyle;
import com.tkid.appsdk.widget.view.PressAlphaTextView;
import com.tkid.eastmoney.R;


/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class TitleBarStyle extends LightBarStyle {

    @Override
    public TextView newTitleView(Context context) {
        return new AppCompatTextView(context);
    }

    @Override
    public TextView newLeftView(Context context) {
        return new PressAlphaTextView(context);
    }

    @Override
    public TextView newRightView(Context context) {
        return new PressAlphaTextView(context);
    }

    @Override
    public Drawable getTitleBarBackground(Context context) {
        return new ColorDrawable(ContextCompat.getColor(context, R.color.common_primary_color));
    }

    @Override
    public Drawable getBackButtonDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.arrows_left_ic);
    }

    @Override
    public Drawable getLeftTitleBackground(Context context) {
        return null;
    }

    @Override
    public Drawable getRightTitleBackground(Context context) {
        return null;
    }

    @Override
    public int getChildHorizontalPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.dp_12);
    }

    @Override
    public int getChildVerticalPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.dp_14);
    }

    @Override
    public float getTitleSize(Context context) {
        return context.getResources().getDimension(R.dimen.sp_15);
    }

    @Override
    public float getLeftTitleSize(Context context) {
        return context.getResources().getDimension(R.dimen.sp_13);
    }

    @Override
    public float getRightTitleSize(Context context) {
        return context.getResources().getDimension(R.dimen.sp_13);
    }

    @Override
    public int getTitleIconPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.dp_2);
    }

    @Override
    public int getLeftIconPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.dp_2);
    }

    @Override
    public int getRightIconPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.dp_2);
    }
}