package com.microple.jademall.weight;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * author: xiaoguagnfei
 * date: 2018/8/20
 * describe:
 */
public class MyRecyclerView extends RecyclerView {
    private TouchListener touchListener;
    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (touchListener!=null)
        touchListener.setState();
        return super.onTouchEvent(e);
    }
    public void setListener(TouchListener listener){
        if (touchListener==null)
            touchListener=listener;
    }
    public interface TouchListener{
        public void setState();
    }

}
