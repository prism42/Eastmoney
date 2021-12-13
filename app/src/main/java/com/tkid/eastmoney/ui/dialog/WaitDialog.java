package com.tkid.eastmoney.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.StringRes;

import com.tkid.appsdk.base.BaseDialog;
import com.tkid.eastmoney.R;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class WaitDialog {

    public static final class Builder
            extends BaseDialog.Builder<Builder> {

        private final TextView mMessageView;

        public Builder(Context context) {
            super(context);
            setContentView(R.layout.wait_dialog);
            setAnimStyle(BaseDialog.ANIM_TOAST);
            setBackgroundDimEnabled(false);
            setCancelable(false);

            mMessageView = findViewById(R.id.tv_wait_message);
        }

        public Builder setMessage(@StringRes int id) {
            return setMessage(getString(id));
        }

        public Builder setMessage(CharSequence text) {
            mMessageView.setText(text);
            mMessageView.setVisibility(text == null ? View.GONE : View.VISIBLE);
            return this;
        }
    }
}
