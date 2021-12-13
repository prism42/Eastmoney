package com.tkid.appsdk.toastutils;

import android.util.Log;

import com.tkid.appsdk.toastutils.config.IToastInterceptor;

import java.lang.reflect.Modifier;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ToastLogInterceptor implements IToastInterceptor {

    @Override
    public boolean intercept(CharSequence text) {
        printToast(text);
        return false;
    }

    protected void printToast(CharSequence text) {
        if (!isLogEnable()) {
            return;
        }

        // 获取调用的堆栈信息
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        for (StackTraceElement stackTrace : stackTraces) {
            // 获取代码行数
            int lineNumber = stackTrace.getLineNumber();
            if (lineNumber <= 0) {
                continue;
            }

            // 获取类的全路径
            String className = stackTrace.getClassName();
            try {
                Class<?> clazz = Class.forName(className);
                if (!filterClass(clazz)) {
                    printLog("(" + stackTrace.getFileName() + ":" + lineNumber + ") " + text.toString());
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    protected boolean isLogEnable() {
        return ToastUtils.isDebugMode();
    }

    protected void printLog(String msg) {
        // 这里解释一下，为什么不用 Log.d，而用 Log.i，因为 Log.d 在魅族 16th 手机上面无法输出日志
        Log.i("ToastUtils", msg);
    }

    protected boolean filterClass(Class<?> clazz) {
        // 排除自身
        if (ToastLogInterceptor.class.equals(clazz)) {
            return true;
        }

        // 排除 ToastUtils 类
        if (ToastUtils.class.equals(clazz)) {
            return true;
        }

        // 是否为接口类
        if (clazz.isInterface()) {
            return true;
        }

        // 是否为抽象类
        if (Modifier.isAbstract(clazz.getModifiers())) {
            return true;
        }

        return false;
    }
}
