package com.tkid.appsdk.toastutils.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tkid.appsdk.toastutils.config.IToastStyle;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
@SuppressWarnings({"unused", "deprecation"})
public class BlackToastStyle implements IToastStyle<TextView> {

    @Override
    public TextView createView(Context context) {
        TextView textView = new TextView(context);
        textView.setId(android.R.id.message);
        textView.setGravity(getTextGravity(context));
        textView.setTextColor(getTextColor(context));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getTextSize(context));

        int horizontalPadding = getHorizontalPadding(context);
        int verticalPadding = getVerticalPadding(context);

        // 适配布局反方向特性
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textView.setPaddingRelative(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        } else {
            textView.setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        }

        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        Drawable background = getBackgroundDrawable(context);
        // 设置背景
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackground(background);
        } else {
            textView.setBackgroundDrawable(background);
        }

        // 设置 Z 轴阴影
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textView.setZ(getTranslationZ(context));
        }

        // 设置最大显示行数
        textView.setMaxLines(getMaxLines(context));
        return textView;
    }

    protected int getTextGravity(Context context) {
        return Gravity.CENTER;
    }

    protected int getTextColor(Context context) {
        return 0XEEFFFFFF;
    }

    protected float getTextSize(Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, context.getResources().getDisplayMetrics());
    }

    protected int getHorizontalPadding(Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, context.getResources().getDisplayMetrics());
    }

    protected int getVerticalPadding(Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, context.getResources().getDisplayMetrics());
    }

    protected Drawable getBackgroundDrawable(Context context) {
        GradientDrawable drawable = new GradientDrawable();
        // 设置颜色
        drawable.setColor(0X88000000);
        // 设置圆角
        drawable.setCornerRadius(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics()));
        return drawable;
    }

    protected float getTranslationZ(Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, context.getResources().getDisplayMetrics());
    }

    protected int getMaxLines(Context context) {
        return 5;
    }
}
