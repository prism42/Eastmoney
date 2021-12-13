package com.tkid.appsdk.toastutils.config;

import android.app.Application;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface IToastStrategy {

    /**
     * 注册策略
     */
    void registerStrategy(Application application);

    /**
     * 绑定样式
     */
    void bindStyle(IToastStyle<?> style);

    /**
     * 创建 Toast
     */
    IToast createToast(Application application);

    /**
     * 显示 Toast
     */
    void showToast(CharSequence text);

    /**
     * 取消 Toast
     */
    void cancelToast();
}
