package com.tkid.appsdk.bar.style;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import com.tkid.appsdk.R;
import com.tkid.appsdk.bar.SelectorDrawable;
import com.tkid.appsdk.bar.TitleBarSupport;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class LightBarStyle extends CommonBarStyle{

    @Override
    public Drawable getTitleBarBackground(Context context) {
        return new ColorDrawable(0xFFFFFFFF);
    }

    @Override
    public Drawable getLeftTitleBackground(Context context) {
        return new SelectorDrawable.Builder()
                .setDefault(new ColorDrawable(0x00000000))
                .setFocused(new ColorDrawable(0x0C000000))
                .setPressed(new ColorDrawable(0x0C000000))
                .build();
    }

    @Override
    public Drawable getRightTitleBackground(Context context) {
        return new SelectorDrawable.Builder()
                .setDefault(new ColorDrawable(0x00000000))
                .setFocused(new ColorDrawable(0x0C000000))
                .setPressed(new ColorDrawable(0x0C000000))
                .build();
    }

    @Override
    public Drawable getBackButtonDrawable(Context context) {
        return TitleBarSupport.getDrawable(context, R.drawable.bar_arrows_left_black);
    }

    @Override
    public ColorStateList getTitleColor(Context context) {
        return ColorStateList.valueOf(0xFF222222);
    }

    @Override
    public ColorStateList getLeftTitleColor(Context context) {
        return ColorStateList.valueOf(0xFF666666);
    }

    @Override
    public ColorStateList getRightTitleColor(Context context) {
        return ColorStateList.valueOf(0xFFA4A4A4);
    }

    @Override
    public Drawable getLineDrawable(Context context) {
        return new ColorDrawable(0xFFECECEC);
    }
}
