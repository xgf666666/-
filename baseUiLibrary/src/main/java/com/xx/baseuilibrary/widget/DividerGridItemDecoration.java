package com.xx.baseuilibrary.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/**
 * @author zhy
 */
public class DividerGridItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable mDivider;


    /**
     * @param context
     * @param res     线的Drawable资源
     */
    public DividerGridItemDecoration(Context context, int res) {
        mDivider = ContextCompat.getDrawable(context, res);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int spanCount = getSpanCount(parent);//每行的item数量
        int position = parent.getChildAdapterPosition(view);
        if (position == 0) {
            //第一个item
            outRect.set(mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth());
        } else if (position < spanCount) {
            //第一行
            outRect.set(0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth());
        } else if (position % spanCount == 0) {
            //第一列
            outRect.set(mDivider.getIntrinsicWidth(), 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), mDivider.getIntrinsicWidth());
        }
    }


    @Override
    public void onDraw(Canvas c, RecyclerView parent, State state) {
        int spanCount = getSpanCount(parent);//每行的item数量
        int childCount = parent.getChildCount();//item总数
        if (childCount < 1) {
            return;
        }
        //画item顶部横线
        for (int i = 0; i < spanCount; i++) {
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            int left = child.getLeft();
            int right = child.getRight() + mDivider.getIntrinsicWidth();
            int top = child.getTop() - mDivider.getIntrinsicHeight();
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
        //画item底部横线
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            int left = child.getLeft();
            int right = child.getRight() + mDivider.getIntrinsicWidth();
            int top = child.getBottom();
            int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

        //画item左边竖线
        for (int i = 0; i < childCount; i++) {
            if (i % spanCount == 0) {
                View child = parent.getChildAt(i);
                if (child == null) {
                    continue;
                }
                int left = child.getLeft() - mDivider.getIntrinsicWidth();
                int right = left + mDivider.getIntrinsicWidth();
                int top = child.getTop() - mDivider.getIntrinsicHeight();
                int bottom = child.getBottom() + mDivider.getIntrinsicHeight();
                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }

        //画item右边竖线
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            if (child == null) {
                continue;
            }
            int left = child.getRight();
            int right = left + mDivider.getIntrinsicWidth();
            int top = child.getTop() - mDivider.getIntrinsicHeight();
            int bottom = child.getBottom() + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }

    }

    //获取列数
    private int getSpanCount(RecyclerView parent) {
        int spanCount = -1;
        LayoutManager layoutManager = parent.getLayoutManager();
        spanCount = ((GridLayoutManager) layoutManager).getSpanCount();
        return spanCount;
    }

}