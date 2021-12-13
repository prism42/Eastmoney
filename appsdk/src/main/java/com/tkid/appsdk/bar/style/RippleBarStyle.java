package com.tkid.appsdk.bar.style;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;

import com.tkid.appsdk.bar.TitleBarSupport;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class RippleBarStyle extends TransparentBarStyle{

    @Override
    public Drawable getLeftTitleBackground(Context context) {
        Drawable drawable = createRippleDrawable(context);
        if (drawable != null) {
            return drawable;
        }
        return super.getLeftTitleBackground(context);
    }

    @Override
    public Drawable getRightTitleBackground(Context context) {
        Drawable drawable = createRippleDrawable(context);
        if (drawable != null) {
            return drawable;
        }
        return super.getRightTitleBackground(context);
    }

    /**
     * 获取水波纹的点击效果
     */
    public Drawable createRippleDrawable(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, typedValue, true)) {
            return TitleBarSupport.getDrawable(context, typedValue.resourceId);
        }
        return null;
    }
}
