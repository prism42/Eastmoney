package com.tkid.appsdk.widget.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public class SimpleLayout extends ViewGroup {

    public SimpleLayout(Context context) {
        super(context);
    }

    public SimpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    public SimpleLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int count = getChildCount();
        int maxHeight = 0;
        int maxWidth = 0;
        int childState = 0;

        // 测量子 View
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            // 被测量的子 View 不能是隐藏的
            if (child.getVisibility() != GONE) {
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                final MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
                maxWidth = Math.max(maxWidth, child.getMeasuredWidth() + params.leftMargin + params.rightMargin);
                maxHeight = Math.max(maxHeight, child.getMeasuredHeight() + params.topMargin + params.bottomMargin);
                childState = combineMeasuredStates(childState, child.getMeasuredState());
            }
        }

        maxWidth += (getPaddingLeft() + getPaddingRight());
        maxHeight += (getPaddingTop() + getPaddingBottom());

        maxWidth = Math.max(maxWidth, getSuggestedMinimumWidth());
        maxHeight = Math.max(maxHeight, getSuggestedMinimumHeight());

        // 测量自身
        setMeasuredDimension(resolveSizeAndState(maxWidth, widthMeasureSpec, childState),
                resolveSizeAndState(maxHeight, heightMeasureSpec,
                        childState << MEASURED_HEIGHT_STATE_SHIFT));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 遍历子 View
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            final MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
            int left = params.leftMargin + getPaddingLeft();
            int top = params.topMargin + getPaddingTop();
            int right = left + child.getMeasuredWidth() + getPaddingRight() + params.rightMargin;
            int bottom = top + child.getMeasuredHeight() + getPaddingBottom() + params.bottomMargin;
            // 将子 View 放置到左上角的位置
            child.layout(left, top, right, bottom);
        }
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams params) {
        return new MarginLayoutParams(params);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams params) {
        return params instanceof MarginLayoutParams;
    }

    @Override
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
