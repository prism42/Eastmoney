package com.tkid.eastmoney.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.HorizontalScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class HSRecyclerView extends RecyclerView {

    private int mTouchSlop;

    public HSRecyclerView(Context context) {
        this(context, null);
    }

    public HSRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HSRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final ViewConfiguration vc = ViewConfiguration.get(getContext());
        mTouchSlop = vc.getScaledTouchSlop();
    }

    private float x1 = 0;
    private float x2 = 0;
    private float y1 = 0;
    private float y2 = 0;
    private HorizontalScrollView mHorizontalScrollView;

    public void setHorizontalScrollView(@NonNull HorizontalScrollView horizontalScrollView) {
        mHorizontalScrollView = horizontalScrollView;
        setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    x1 = event.getX();
                    y1 = event.getY();
                    mHorizontalScrollView.onTouchEvent(event);
                }
                if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    x2 = event.getX();
                    y2 = event.getY();
                    if (Math.abs(x1 - x2) - Math.abs(y1 - y2) > mTouchSlop) {//左右滑动，横向titleScrollView跟着动
                        mHorizontalScrollView.onTouchEvent(event);
                        return true;//消费掉事件///important!!!
                    }
                }
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    x2 = event.getX();
                    y2 = event.getY();
                    if (Math.abs(x1 - x2) - Math.abs(y1 - y2) > mTouchSlop) {
                        mHorizontalScrollView.onTouchEvent(event);
                        return true;
                    }
                }
                return false;
            }
        });
    }
}
