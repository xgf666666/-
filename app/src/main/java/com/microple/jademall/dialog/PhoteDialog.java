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

import com.microple.jademall.R;


/**
 * Created by JacobHHH on 2018/4/22.
 */

public class PhoteDialog extends Dialog implements View.OnClickListener {

    private Context mContext;



    public PhoteDialog(@NonNull Context context) {
        super(context);
        this.mContext=context;
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//        this.setCanceledOnTouchOutside(false);
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
    private LinearLayout ll_quxiao;
    private LinearLayout ll_photo;
    private LinearLayout ll_camara;
    private void initView() {
        View view = View.inflate(mContext, R.layout.view_photo, null);
        view.findViewById(R.id.ll_quxiao).setOnClickListener(this);
        view.findViewById(R.id.ll_photo).setOnClickListener(this);
        view.findViewById(R.id.ll_camara).setOnClickListener(this);
        ll_quxiao = view.findViewById(R.id.ll_quxiao);
        ll_photo = view.findViewById(R.id.ll_photo);
        ll_camara = view.findViewById(R.id.ll_camara);
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
            case R.id.ll_quxiao:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.cancel(1);
                }
                break;
            case R.id.ll_photo:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.cancel(2);
                }
                break;
            case R.id.ll_camara:
                if (mOnBtnClickListener!=null){
                    mOnBtnClickListener.cancel(3);
                }
                break;
        }
    }

    private OnBtnClickListener mOnBtnClickListener;

    public interface OnBtnClickListener{
        void cancel(int index);
    }

    public void setOnBtnClickListener(OnBtnClickListener listener){
        this.mOnBtnClickListener=listener;
    }
}
