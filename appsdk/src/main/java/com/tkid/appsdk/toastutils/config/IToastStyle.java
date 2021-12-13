package com.tkid.appsdk.toastutils.config;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface IToastStyle<V extends View> {

    /**
     * 创建 Toast 视图
     */
    V createView(Context context);

    /**
     * 获取 Toast 显示重心
     */
    default int getGravity() {
        return Gravity.CENTER;
    }

    /**
     * 获取 Toast 水平偏移
     */
    default int getXOffset() {
        return 0;
    }

    /**
     * 获取 Toast 垂直偏移
     */
    default int getYOffset() {
        return 0;
    }

    /**
     * 获取 Toast 水平间距
     */
    default float getHorizontalMargin() {
        return 0;
    }

    /**
     * 获取 Toast 垂直间距
     */
    default float getVerticalMargin() {
        return 0;
    }
}
