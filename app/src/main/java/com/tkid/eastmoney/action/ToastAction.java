package com.tkid.eastmoney.action;

import androidx.annotation.StringRes;

import com.tkid.appsdk.toastutils.ToastUtils;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface ToastAction {

    default void toast(CharSequence text) {
        ToastUtils.show(text);
    }

    default void toast(@StringRes int id) {
        ToastUtils.show(id);
    }

    default void toast(Object object) {
        ToastUtils.show(object);
    }
}
