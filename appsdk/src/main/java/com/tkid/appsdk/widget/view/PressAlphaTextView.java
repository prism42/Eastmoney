package com.tkid.appsdk.widget.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class PressAlphaTextView extends AppCompatTextView {

    public PressAlphaTextView(@NonNull Context context) {
        super(context);
    }

    public PressAlphaTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PressAlphaTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchSetPressed(boolean pressed) {
        // 判断当前手指是否按下了
        if (pressed) {
            setAlpha(0.5f);
        } else {
            setAlpha(1f);
        }
    }
}
