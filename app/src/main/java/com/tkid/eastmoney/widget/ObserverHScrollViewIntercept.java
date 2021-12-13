package com.tkid.eastmoney.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ObserverHScrollViewIntercept extends LinearLayout {

    public ObserverHScrollViewIntercept(Context context) {
        this(context, null);
    }

    public ObserverHScrollViewIntercept(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObserverHScrollViewIntercept(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }
}
