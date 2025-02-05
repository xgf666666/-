package com.xx.baseuilibrary.mvp.lcec;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.xx.baseuilibrary.R;
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment;
import com.xx.baseutilslibrary.common.XxResourceUtil;

import org.jetbrains.annotations.Nullable;

import java.net.ConnectException;
import java.util.ArrayList;


/**
 * BaseFragment
 * (๑• . •๑)
 * 类描述:
 * Created by 雷小星🍀 on 2017/6/13 18:10
 */

public abstract class BaseLcecFragment<ContentView extends View, Data> extends BaseMvpViewFragment {
    private View viewLoading;
    private ContentView viewContent;
    private View viewError;
    private View viewCheckNet;
    private ArrayList<View> mViews;

    @Override
    protected  void init(@Nullable View view) {
        initLcenView(view);
    }
    //    @CallSuper
//    @Override
//    public abstract void initView(View view) {
//        initLcenView(view);
//    }

    /**
     * 初始化Lcec
     */
    private void initLcenView(View view) {

        viewLoading = view.findViewById(XxResourceUtil.getId(view.getContext(), "view_loading"));
        viewContent = view.findViewById(XxResourceUtil.getId(view.getContext(), "view_content"));
        viewError = view.findViewById(XxResourceUtil.getId(view.getContext(), "view_error"));
        viewCheckNet = view.findViewById(XxResourceUtil.getId(view.getContext(), "view_check_net"));

        if (viewLoading == null) {
            throw new NullPointerException(this.getClass().getName()+" viewLoading没有被设置在布局中");
        }
        if (viewContent == null) {
            throw new NullPointerException(this.getClass().getName()+" view_content没有被设置在布局中");
        }
        if (viewError == null) {
            throw new NullPointerException(this.getClass().getName()+" view_error没有被设置在布局中");
        }
        if (viewCheckNet == null) {
            throw new NullPointerException(this.getClass().getName()+" view_check_net没有被设置在布局中");
        }
        //----------
        mViews = new ArrayList<>();
        mViews.add(viewLoading);
        mViews.add(viewContent);
        mViews.add(viewError);
        mViews.add(viewCheckNet);
        //--------------
        view.findViewById(R.id.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击错误重新加载页面
//                showLoading();
                loadData(true);
            }
        });

        view.findViewById(R.id.tv_no_net).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击没有网络跳转到系统设置界面
                showNoNetWorkDlg();
            }
        });
        //初始显示加载中对话框
//        showLoading();
    }


    public void addViewtoViews(View view){
        mViews.add(view);
    }

    /**
     * 当判断当前手机没有网络时选择是否打开网络设置
     */
    public void showNoNetWorkDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("当前无网络")
                .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        goSettings();
                    }
                }).setNegativeButton("知道了", null).show();
    }

    /**
     * 跳转到设置界面
     */
    public void goSettings() {
        // 跳转到系统的网络设置界面
        Intent intent;
        // 先判断当前系统版本
        if (android.os.Build.VERSION.SDK_INT > 10) {  // 3.0以上
            intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
        } else {
            intent = new Intent();
            intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
        }
        startActivity(intent);
    }

    /**
     * 获取内容视图
     *
     * @return 内容视图
     */
    protected ContentView getContentView() {
        return viewContent;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mViews != null) {
            mViews.clear();
            mViews = null;
        }
    }

    /**
     * 控制显示的View
     *
     * @param view 需要显示的View
     */
    protected void showView(View view) {
        for (View v :
                mViews) {
            v.setVisibility(v == view ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 显示加载中布局
     */
    public void showLoading() {
        showView(viewLoading);
    }

    /**
     * 显示内容布局
     */
    protected void showContent() {
        showView(viewContent);
    }

    /**
     * 显示错误布局
     */
    private void showError() {
        showView(viewError);
    }

    /**
     * 显示检查网络布局
     */
    private void showCheckNet() {
        showView(viewCheckNet);
    }

    /**
     * 显示错误信息
     *
     * @param throwable 错误
     * @param refresh   是否是刷新数据时
     */
    public void showError(Throwable throwable, boolean refresh) {
        if (throwable instanceof ConnectException || throwable.getMessage().equals("网络错误")) {
            //如果时网络出错的错误，显示检查检查网络
            showCheckNet();
        } else if (!refresh) {
            //如果在加载更多时出错，toast提示
            showContent();
            showToast(throwable.getMessage());
        } else {
            //其他错误显示通用错误页面
            showError();
        }

    }

    /**
     * 加载数据
     *
     * @param refresh 是否是刷新数据
     */
    protected abstract void loadData(boolean refresh);

    /**
     * 设置数据
     *
     * @param data 数据
     */
    public abstract void setData(Data data);

}
