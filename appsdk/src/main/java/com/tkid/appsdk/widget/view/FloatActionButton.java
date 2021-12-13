package com.tkid.appsdk.widget.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public final class FloatActionButton extends AppCompatImageView {

    /** 动画显示时长 */
    private static final int ANIM_TIME = 300;

    public FloatActionButton(@NonNull Context context) {
        super(context);
    }

    public FloatActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FloatActionButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 显示
     */
    public void show() {
        removeCallbacks(mHideRunnable);
        postDelayed(mShowRunnable, ANIM_TIME * 2);
    }

    /**
     * 隐藏
     */
    public void hide() {
        removeCallbacks(mShowRunnable);
        post(mHideRunnable);
    }

    /**
     * 显示悬浮球动画
     */
    private final Runnable mShowRunnable = () -> {
        if (getVisibility() == View.INVISIBLE) {
            setVisibility(View.VISIBLE);
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
        valueAnimator.setDuration(ANIM_TIME);
        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            setAlpha(value);
            setScaleX(value);
            setScaleY(value);
        });
        valueAnimator.start();
    };

    /**
     * 隐藏悬浮球动画
     */
    private final Runnable mHideRunnable = () -> {
        if (getVisibility() == View.INVISIBLE) {
            return;
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f);
        valueAnimator.setDuration(ANIM_TIME);
        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            setAlpha(value);
            setScaleX(value);
            setScaleY(value);
            if (value == 0) {
                setVisibility(View.INVISIBLE);
            }
        });
        valueAnimator.start();
    };
}
