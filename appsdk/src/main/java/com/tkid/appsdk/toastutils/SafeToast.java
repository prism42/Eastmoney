package com.tkid.appsdk.toastutils;

import android.annotation.TargetApi;
import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.widget.Toast;

import java.lang.reflect.Field;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
@TargetApi(Build.VERSION_CODES.KITKAT)
@SuppressWarnings("all")
public final class SafeToast extends SystemToast {

    public SafeToast(Application application) {
        super(application);

        // 反射 Toast 中的字段
        try {
            // 获取 mTN 字段对象
            Field mTNField = Toast.class.getDeclaredField("mTN");
            mTNField.setAccessible(true);
            Object mTN = mTNField.get(this);

            // 获取 mTN 中的 mHandler 字段对象
            Field mHandlerField = mTNField.getType().getDeclaredField("mHandler");
            mHandlerField.setAccessible(true);
            Handler mHandler = (Handler) mHandlerField.get(mTN);

            // 偷梁换柱
            mHandlerField.set(mTN, new SafeHandler(mHandler));

        } catch (IllegalAccessException | NoSuchFieldException e) {
            // Android 9.0 上反射会出现报错
            // Accessing hidden field Landroid/widget/Toast;->mTN:Landroid/widget/Toast$TN;
            // java.lang.NoSuchFieldException: No field mTN in class Landroid/widget/Toast;
            e.printStackTrace();
        }
    }
}
