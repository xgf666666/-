package com.xx.baseuilibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 2018/6/7 9:04
 * yangyong
 */
public class DividerListItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;
    private Boolean mShowTop = false;
    private Boolean mShowButtom = false;

    /**
     * @param context
     * @param res        线的Drawable资源
     * @param showTop    顶部线是否展示
     * @param showButtom 底部线是展示
     */
    public DividerListItemDecoration(Context context, int res, boolean showTop, boolean showButtom) {
        mDivider = ContextCompat.getDrawable(context, res);
        mShowTop = showTop;
        mShowButtom = showButtom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) == 0) {
            if (mShowTop) {
                outRect.set(0, mDivider.getIntrinsicWidth(), 0, mDivider.getIntrinsicWidth());
            } else {
                outRect.set(0, 0, 0, mDivider.getIntrinsicWidth());
            }
        } else if (parent.getChildAdapterPosition(view) == parent.getAdapter().getItemCount() - 1) {
            if (mShowButtom) {
                outRect.set(0, 0, 0, mDivider.getIntrinsicWidth());
            } else {
                outRect.set(0, 0, 0, 0);
            }
        } else {
            outRect.set(0, 0, 0, mDivider.getIntrinsicWidth());
        }
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int childCount = parent.getAdapter().getItemCount();
        if (childCount < 1) {
            return;
        }
        //画item横线
        for (int i = 0; i < childCount; i++) {
            if (i == 0 && mShowTop) {
                View child = parent.getChildAt(i);
                int left = child.getLeft();
                int right = child.getRight();
                int top = child.getTop() - mDivider.getIntrinsicHeight();
                int bottom = top + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
            if (i == childCount - 1 && !mShowButtom) {
                break;
            }
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            int left = child.getLeft();
            int right = child.getRight();
            int top = child.getBottom();
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}