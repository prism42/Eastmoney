package com.tkid.eastmoney.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

import com.tkid.appsdk.bar.TitleBar;
import com.tkid.appsdk.base.BaseActivity;
import com.tkid.appsdk.base.BaseDialog;
import com.tkid.eastmoney.R;
import com.tkid.eastmoney.action.TitleBarAction;
import com.tkid.eastmoney.action.ToastAction;
import com.tkid.eastmoney.ui.dialog.WaitDialog;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public abstract class AppActivity extends BaseActivity implements ToastAction, TitleBarAction {

    /** 标题栏对象 */
    private TitleBar mTitleBar;

    /** 加载对话框 */
    private BaseDialog mDialog;
    /** 对话框数量 */
    private int mDialogCount;

    /**
     * 当前加载对话框是否在显示中
     */
    public boolean isShowDialog() {
        return mDialog != null && mDialog.isShowing();
    }

    /**
     * 显示加载对话框
     */
    public void showDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }

        mDialogCount++;
        postDelayed(() -> {
            if (mDialogCount <= 0 || isFinishing() || isDestroyed()) {
                return;
            }

            if (mDialog == null) {
                mDialog = new WaitDialog.Builder(this)
                        .setCancelable(false)
                        .create();
            }
            if (!mDialog.isShowing()) {
                mDialog.show();
            }
        }, 300);
    }

    /**
     * 隐藏加载对话框
     */
    public void hideDialog() {
        if (isFinishing() || isDestroyed()) {
            return;
        }

        if (mDialogCount > 0) {
            mDialogCount--;
        }

        if (mDialogCount != 0 || mDialog == null || !mDialog.isShowing()) {
            return;
        }

        mDialog.dismiss();
    }

    @Override
    protected void initLayout() {
        super.initLayout();

        if (getTitleBar() != null) {
            getTitleBar().setOnTitleBarListener(this);
        }
    }

    /**
     * 是否使用沉浸式状态栏
     */
    protected boolean isStatusBarEnabled() {
        return true;
    }

    /**
     * 状态栏字体深色模式
     */
    protected boolean isStatusBarDarkFont() {
        return true;
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(@StringRes int id) {
        setTitle(getString(id));
    }

    /**
     * 设置标题栏的标题
     */
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (getTitleBar() != null) {
            getTitleBar().setTitle(title);
        }
    }

    @Override
    @Nullable
    public TitleBar getTitleBar() {
        if (mTitleBar == null) {
            mTitleBar = obtainTitleBar(getContentView());
        }
        return mTitleBar;
    }

    @Override
    public void onLeftClick(View view) {
        onBackPressed();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransition(R.anim.right_in_activity, R.anim.right_out_activity);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_in_activity, R.anim.left_out_activity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isShowDialog()) {
            hideDialog();
        }
        mDialog = null;
    }
}
