package com.tkid.eastmoney;

import android.app.Application;

import com.tencent.mmkv.MMKV;
import com.tkid.appsdk.bar.TitleBar;
import com.tkid.appsdk.toastutils.ToastLogInterceptor;
import com.tkid.appsdk.toastutils.ToastUtils;
import com.tkid.eastmoney.manager.ActivityManager;
import com.tkid.eastmoney.manager.other.AppConfig;
import com.tkid.eastmoney.manager.other.TitleBarStyle;
import com.tkid.eastmoney.manager.other.ToastStyle;

import org.litepal.LitePal;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDK(this);
    }

    private void initSDK(Application application) {
        MMKV.initialize(this);
        LitePal.initialize(this);
        // 设置标题栏初始化器
        TitleBar.setDefaultStyle(new TitleBarStyle());
        // 初始化吐司
        ToastUtils.init(application, new ToastStyle());
        // 设置调试模式
        ToastUtils.setDebugMode(AppConfig.isDebug());
        // 设置 Toast 拦截器
        ToastUtils.setInterceptor(new ToastLogInterceptor());
        // Activity 栈管理初始化
        ActivityManager.getInstance().init(application);
    }
}
