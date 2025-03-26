package com.gohsdk.ui.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 参考
 * <a href="https://juejin.cn/post/6911582503212384263">安卓方案类-应用内悬浮窗适配方案实战</a>
 *
 * 存在 bug，轻微拖动的时候会判断为点击，不会吸边
 *
 * 另外不能直接用 id，改成 drawable
 *
 * 另一个解决方案：https://juejin.cn/post/7126475397645991972
 * https://juejin.cn/post/7385747507954057254
 * https://juejin.cn/post/6951608145537925128
 */
public class FloatingView extends DragViewLayout {

    public FloatingView(Context context, int resId) {
        super(context);
        setClickable(true);
        final ImageView floatView = new ImageView(context);
        floatView.setImageResource(resId);
        floatView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了悬浮球", Toast.LENGTH_SHORT).show();
            }
        });
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        addView(floatView, params);
    }
}
