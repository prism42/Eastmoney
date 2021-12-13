package com.tkid.eastmoney.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class ObserverHScrollView extends HorizontalScrollView {

    ScrollViewObserver mScrollViewObserver = new ScrollViewObserver();

    public ObserverHScrollView(Context context) {
        this(context, null);
    }

    public ObserverHScrollView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ObserverHScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {

        if (mScrollViewObserver != null) {
            mScrollViewObserver.notifyOnScrollChanged(l, t, oldl, oldt);
        }

        super.onScrollChanged(l, t, oldl, oldt);
    }


    public void addOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.addOnScrollChangedListener(listener);
    }

    public void removeOnScrollChangedListener(OnScrollChangedListener listener) {
        mScrollViewObserver.removeOnScrollChangedListener(listener);
    }


    /**
     * subscription listener
     */
    public static class ScrollViewObserver {
        List<OnScrollChangedListener> mList;

        public ScrollViewObserver() {
            super();
            mList = new ArrayList<>();

        }

        /**
         * subscribe scroll event
         *
         * @param listener
         */
        public void addOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.add(listener);
        }

        /**
         * unsubscribe scroll event
         *
         * @param listener
         */
        public void removeOnScrollChangedListener(OnScrollChangedListener listener) {
            mList.remove(listener);
        }

        public void notifyOnScrollChanged(int l, int t, int oldl, int oldt) {
            if (mList == null || mList.size() == 0) {
                return;
            }
            for (int i = 0; i < mList.size(); i++) {
                if (mList.get(i) != null) {
                    mList.get(i).onScrollChanged(l, t, oldl, oldt);
                }
            }
        }

    }

    /*
     * called when scroll event received
     */
    public interface OnScrollChangedListener {
        void onScrollChanged(int l, int t, int oldl, int oldt);
    }
}
