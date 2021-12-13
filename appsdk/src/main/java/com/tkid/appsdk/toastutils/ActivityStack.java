package com.tkid.appsdk.toastutils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ActivityStack implements Application.ActivityLifecycleCallbacks {

    /**
     * 注册
     */
    static ActivityStack register(Application application) {
        ActivityStack lifecycle = new ActivityStack();
        application.registerActivityLifecycleCallbacks(lifecycle);
        return lifecycle;
    }

    /** 前台 Activity 对象 */
    private Activity mForegroundActivity;

    public Activity getForegroundActivity() {
        return mForegroundActivity;
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {}

    @Override
    public void onActivityStarted(Activity activity) {}

    @Override
    public void onActivityResumed(Activity activity) {
        mForegroundActivity = activity;
    }

    @Override
    public void onActivityPaused(Activity activity) {
        if (mForegroundActivity != activity) {
            return;
        }
        mForegroundActivity = null;
    }

    @Override
    public void onActivityStopped(Activity activity) {}

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {}

    @Override
    public void onActivityDestroyed(Activity activity) {}
}
