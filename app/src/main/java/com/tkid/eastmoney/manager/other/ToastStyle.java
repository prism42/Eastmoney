package com.tkid.eastmoney.manager.other;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;

import com.tkid.appsdk.toastutils.style.BlackToastStyle;
import com.tkid.eastmoney.R;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class ToastStyle extends BlackToastStyle {

    @Override
    protected Drawable getBackgroundDrawable(Context context) {
        GradientDrawable drawable = new GradientDrawable();
        // 设置颜色
        drawable.setColor(0X88000000);
        // 设置圆角
        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (int) context.getResources().getDimension(R.dimen.button_circle_size), context.getResources().getDisplayMetrics()));
        return drawable;
    }

    @Override
    protected float getTextSize(Context context) {
        return context.getResources().getDimension(R.dimen.sp_14);
    }

    @Override
    protected int getHorizontalPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.sp_24);
    }

    @Override
    protected int getVerticalPadding(Context context) {
        return (int) context.getResources().getDimension(R.dimen.sp_16);
    }
}
