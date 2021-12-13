package com.tkid.appsdk.base.action;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface ResourcesAction {

    Context getContext();

    default Resources getResources() {
        return getContext().getResources();
    }

    default String getString(@StringRes int id) {
        return getContext().getString(id);
    }

    default String getString(@StringRes int id, Object... formatArgs) {
        return getResources().getString(id, formatArgs);
    }

    default Drawable getDrawable(@DrawableRes int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

    @ColorInt
    default int getColor(@ColorRes int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    default <S> S getSystemService(@NonNull Class<S> serviceClass) {
        return ContextCompat.getSystemService(getContext(), serviceClass);
    }

}
