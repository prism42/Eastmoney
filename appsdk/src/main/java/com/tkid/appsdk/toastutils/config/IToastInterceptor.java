package com.tkid.appsdk.toastutils.config;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface IToastInterceptor {
    /**
     * 根据显示的文本决定是否拦截该 Toast
     */
    boolean intercept(CharSequence text);
}
