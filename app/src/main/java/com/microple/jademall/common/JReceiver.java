package com.microple.jademall.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.microple.jademall.MainActivity;
import com.microple.jademall.bean.ImageDetail;
import com.microple.jademall.bean.Notify;
import com.microple.jademall.ui.home.activity.GoodsDetailActivity;
import com.microple.jademall.ui.home.activity.ImageDetailActivity;
import com.microple.jademall.ui.live.activity.LiveDetailsActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * author: xiaoguagnfei
 * date: 2018/9/13
 * describe:
 */
public class JReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.i("bundle",bundle.toString());
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())){
            Log.i("extrassss",""+bundle.getString(JPushInterface.EXTRA_EXTRA));
        }else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())){
            Log.i("extrassss",""+bundle.getString(JPushInterface.EXTRA_EXTRA));
            Notify notify=new Gson().fromJson(bundle.getString(JPushInterface.EXTRA_EXTRA), Notify.class);
            if (notify.getType()==2){
                if (MyLifecycleHandler.isApplicationInForeground()){
                    GoodsDetailActivity.Companion.startGoodsDetailActivity(context,notify.getType_id());
                }else {
                    MainActivity.Companion.startMainActivity(context);
                    GoodsDetailActivity.Companion.startGoodsDetailActivity(context,notify.getType_id());

                }
            }else if (notify.getType()==3){
                if (MyLifecycleHandler.isApplicationInForeground()){
                    LiveDetailsActivity.Companion.startLiveDetail(context,notify.getType_id());
                }else {
                    MainActivity.Companion.startMainActivity(context);
                    LiveDetailsActivity.Companion.startLiveDetail(context,notify.getType_id());
                }
            }
        }
    }
}
