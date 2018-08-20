package com.microple.jademall.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.microple.jademall.R;


/**
 * Created by JacobHHH on 2018/4/22.
 */

public class TextDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private TextView mTv_title;
    private TextView mTv_content;
    private TextView mTv_cancel;


    public TextDialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        this.setCanceledOnTouchOutside(false);
        this.getWindow().setGravity(Gravity.BOTTOM);
        Window window = this.getWindow();
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attr = window.getAttributes();
            if (attr != null) {
                attr.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                attr.width = ViewGroup.LayoutParams.MATCH_PARENT;
                //设置dialog 在布局中的位置
                attr.gravity = Gravity.BOTTOM;

                window.setAttributes(attr);
            }

        initView();
    }

    private void initView() {
        View view = View.inflate(mContext, R.layout.view_text_dialig, null);
        view.findViewById(R.id.tv_cancel).setOnClickListener(this);
        mTv_title = view.findViewById(R.id.tv_title);
        mTv_content = view.findViewById(R.id.tv_content);
        mTv_cancel = view.findViewById(R.id.tv_cancel);
        setContentView(view);
    }

    public void setTitle(String titleText, boolean isVisibility){
        mTv_title.setText(titleText);
        mTv_title.setVisibility(isVisibility ? View.VISIBLE : View.GONE);
    }

    public void setContent(String contentText){
        mTv_content.setText(contentText);
    }

    public void setCancelButtonText(String cancelText){
        mTv_cancel.setText(cancelText);
    }
    @Override
    public void show() {
        if (!((Activity)mContext).isFinishing()){
            super.show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.cancel();
                }
                break;
        }
    }

    private OnBtnClickListener mOnBtnClickListener;

    public interface OnBtnClickListener{
        void cancel();
    }

    public void setOnBtnClickListener(OnBtnClickListener listener){
        this.mOnBtnClickListener=listener;
    }
}
