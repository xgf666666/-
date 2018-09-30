package com.microple.jademall.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.microple.jademall.MainActivity;

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
//            getMessage(context,bundle);
            Intent intent1=new Intent(context, MainActivity.class);
            context.startActivity(intent1);
        }
    }
    private void getMessage(Context context,Bundle bundle){
        if (MyLifecycleHandler.isApplicationInForeground()){
            Constants.addUnReadMessage();
        }else {

        }

    }
}
