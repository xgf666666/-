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
import android.widget.ImageView;
import android.widget.TextView;

import com.microple.jademall.R;


/**
 * Created by JacobHHH on 2018/4/22.
 */

public class ShareDialog extends Dialog implements View.OnClickListener {

    private Context mContext;
    private ImageView iv_wx,iv_wxpyq,iv_qq,iv_weibo;
    private TextView tv_cancel;



    public ShareDialog(@NonNull Context context) {
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
        View view = View.inflate(mContext, R.layout.dialog_share, null);
        view.findViewById(R.id.tv_cancel).setOnClickListener(this);
        iv_wx = view.findViewById(R.id.iv_wx);
        iv_wxpyq = view.findViewById(R.id.iv_wxpyq);
        iv_qq = view.findViewById(R.id.iv_qq);
        iv_weibo = view.findViewById(R.id.iv_weibo);
        tv_cancel = view.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(this);
        iv_wx.setOnClickListener(this);
        iv_wxpyq.setOnClickListener(this);
        iv_qq.setOnClickListener(this);
        iv_weibo.setOnClickListener(this);
        setContentView(view);
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
            case R.id.iv_wx:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.wxShare();
                }
                break;
            case R.id.iv_wxpyq:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.wxwcShare();
                }
                break;
            case R.id.iv_qq:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.QQShare();
                }
                break;
            case R.id.iv_weibo:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.weiboShare();
                }
                break;
        }
    }

    private OnBtnClickListener mOnBtnClickListener;

    public interface OnBtnClickListener{
        void cancel();
        void wxShare();
        void QQShare();
        void wxwcShare();
        void weiboShare();
    }

    public void setOnBtnClickListener(OnBtnClickListener listener){
        this.mOnBtnClickListener=listener;
    }
}
