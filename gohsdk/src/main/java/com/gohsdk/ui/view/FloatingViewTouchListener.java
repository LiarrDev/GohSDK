package com.gohsdk.ui.view;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import com.gohsdk.utils.DeviceUtil;

public class FloatingViewTouchListener implements View.OnTouchListener {

    private final WindowManager.LayoutParams params;
    private final WindowManager windowManager;
    private int eventX, eventY;
    private int downX, downY;
    private final float performClickDistance = 8F;

    public FloatingViewTouchListener(WindowManager.LayoutParams params, WindowManager windowManager) {
        this.params = params;
        this.windowManager = windowManager;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                eventX = (int) event.getRawX();
                eventY = (int) event.getRawY();
                downX = eventX;
                downY = eventY;
                break;
            case MotionEvent.ACTION_MOVE:
                int nowX = (int) event.getRawX();
                int nowY = (int) event.getRawY();
                int movedX = nowX - eventX;
                int movedY = nowY - eventY;
                eventX = nowX;
                eventY = nowY;
                params.x = params.x + movedX;
                params.y = params.y + movedY;
                windowManager.updateViewLayout(v, params);
                break;
            case MotionEvent.ACTION_UP:
                double moveDistance = Math.sqrt((downX - eventX) * (downX - eventX) + (downY - eventY) * (downY - eventY));
                if (moveDistance <= performClickDistance) {
                    v.performClick();
                } else {
                    int screenWidth = DeviceUtil.getScreenWidth();
                    int sideX;
                    if (event.getRawX() > screenWidth / 2) {
                        sideX = screenWidth - v.getWidth();
                    } else {
                        sideX = 0;
                    }
                    updatePositionWithAnimation(v, (int) event.getRawX() - v.getWidth() / 2, sideX);
                }
                break;
        }
        return true;
    }

    private void updatePositionWithAnimation(View v, int startX, int endX) {
        ValueAnimator animator = ValueAnimator.ofInt(startX, endX);
        animator.setDuration(200).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                params.x = (int) animation.getAnimatedValue();
                windowManager.updateViewLayout(v, params);
            }
        });
    }
}
