package com.tkid.appsdk.bar;

import android.view.View;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface OnTitleBarListener {

    /**
     * 左项被点击
     *
     * @param view     被点击的左项View
     */
    void onLeftClick(View view);

    /**
     * 标题被点击
     *
     * @param view     被点击的标题View
     */
    void onTitleClick(View view);

    /**
     * 右项被点击
     *
     * @param view     被点击的右项View
     */
    void onRightClick(View view);
}
