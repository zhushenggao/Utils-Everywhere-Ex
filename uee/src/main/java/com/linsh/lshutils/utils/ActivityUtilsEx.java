package com.linsh.lshutils.utils;

import android.app.Activity;
import android.os.SystemClock;
import android.view.MotionEvent;

import com.linsh.utilseverywhere.HandlerUtils;
import com.linsh.utilseverywhere.RandomUtils;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2020/03/03
 *    desc   :
 * </pre>
 */
public class ActivityUtilsEx {

    /**
     * 模拟点击
     *
     * @param activity 用于发送点击事件的 Activity
     * @param x        点击坐标 x
     * @param y        点击坐标 y
     */
    public static void performClick(final Activity activity, final int x, final int y) {
        final long downTime = SystemClock.uptimeMillis();
        MotionEvent event = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, x, y, 0);
        activity.dispatchTouchEvent(event);
        HandlerUtils.postRunnable(new Runnable() {
            @Override
            public void run() {
                MotionEvent event = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, x, y, 0);
                activity.dispatchTouchEvent(event);
            }
        }, RandomUtils.getInt(100, 500));
    }

    /**
     * 模拟长按
     *
     * @param activity 用于发送点击事件的 Activity
     * @param x        点击坐标 x
     * @param y        点击坐标 y
     */
    public static void performLongClick(final Activity activity, final int x, final int y) {
        final long downTime = SystemClock.uptimeMillis();
        MotionEvent event = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, x, y, 0);
        activity.dispatchTouchEvent(event);
        HandlerUtils.postRunnable(new Runnable() {
            @Override
            public void run() {
                MotionEvent event = MotionEvent.obtain(downTime, SystemClock.uptimeMillis(), MotionEvent.ACTION_UP, x, y, 0);
                activity.dispatchTouchEvent(event);
            }
        }, RandomUtils.getInt(600, 1200));
    }
}
