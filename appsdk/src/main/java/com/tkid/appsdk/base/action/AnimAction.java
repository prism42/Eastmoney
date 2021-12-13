package com.tkid.appsdk.base.action;

import com.tkid.appsdk.R;

/**
 * author : Prism
 * Believe and act as if it were impossible to fail.
 * 心怀不败之志，脚踏不凡之路.
 * He who has a why to live can bear almost any how.
 * 知生命之意者，亦可承其重.
 * desc   :
 */
public interface AnimAction {

    /** 默认动画效果 */
    int ANIM_DEFAULT = -1;

    /** 没有动画效果 */
    int ANIM_EMPTY = 0;

    /** 缩放动画 */
    int ANIM_SCALE = R.style.ScaleAnimStyle;

    /** IOS 动画 */
    int ANIM_IOS = R.style.IOSAnimStyle;

    /** 吐司动画 */
    int ANIM_TOAST = android.R.style.Animation_Toast;

    /** 顶部弹出动画 */
    int ANIM_TOP = R.style.TopAnimStyle;

    /** 底部弹出动画 */
    int ANIM_BOTTOM = R.style.BottomAnimStyle;

    /** 左边弹出动画 */
    int ANIM_LEFT = R.style.LeftAnimStyle;

    /** 右边弹出动画 */
    int ANIM_RIGHT = R.style.RightAnimStyle;
}
