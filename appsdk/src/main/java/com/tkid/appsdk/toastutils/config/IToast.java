package com.tkid.appsdk.toastutils.config;

import android.view.View;
import android.widget.TextView;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
@SuppressWarnings("unused")
public interface IToast {

    /**
     * 显示
     */
    void show();

    /**
     * 取消
     */
    void cancel();

    /**
     * 设置文本
     */
    void setText(int id);

    void setText(CharSequence text);

    /**
     * 设置布局
     */
    void setView(View view);

    /**
     * 获取布局
     */
    View getView();

    /**
     * 设置显示时长
     */
    void setDuration(int duration);

    /**
     * 获取显示时长
     */
    int getDuration();

    /**
     * 设置重心偏移
     */
    void setGravity(int gravity, int xOffset, int yOffset);

    /**
     * 获取显示重心
     */
    int getGravity();

    /**
     * 获取水平偏移
     */
    int getXOffset();

    /**
     * 获取垂直偏移
     */
    int getYOffset();

    /**
     * 设置屏幕间距
     */
    void setMargin(float horizontalMargin, float verticalMargin);

    /**
     * 设置水平间距
     */
    float getHorizontalMargin();

    /**
     * 设置垂直间距
     */
    float getVerticalMargin();

    /**
     * 智能获取用于显示消息的 TextView
     */
    default TextView findMessageView(View view) {
        if (view instanceof TextView) {
            if (view.getId() == View.NO_ID) {
                view.setId(android.R.id.message);
            } else if (view.getId() != android.R.id.message) {
                // 必须将 TextView 的 id 值设置成 android.R.id.message
                throw new IllegalArgumentException("You must set the ID value of TextView to android.R.id.message");
            }
            return (TextView) view;
        }

        if (view.findViewById(android.R.id.message) instanceof TextView) {
            return ((TextView) view.findViewById(android.R.id.message));
        }

        // 如果设置的布局没有包含一个 TextView 则抛出异常，必须要包含一个 id 值成 android.R.id.message 的 TextView
        throw new IllegalArgumentException("You must include a TextView with an ID value of android.R.id.message");
    }
}
