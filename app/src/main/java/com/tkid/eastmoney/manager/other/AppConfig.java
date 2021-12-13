package com.tkid.eastmoney.manager.other;


import com.tkid.eastmoney.BuildConfig;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class AppConfig {

    /**
     * 当前是否为调试模式
     */
    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    /**
     * 获取当前构建的模式
     */
    public static String getBuildType() {
        return BuildConfig.BUILD_TYPE;
    }

    /**
     * 获取当前应用的包名
     */
    public static String getPackageName() {
        return BuildConfig.APPLICATION_ID;
    }

    /**
     * 获取当前应用的版本名
     */
    public static String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    /**
     * 获取当前应用的版本码
     */
    public static int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }
}
