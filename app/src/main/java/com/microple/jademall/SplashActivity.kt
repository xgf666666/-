package com.microple.jademall

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.microple.jademall.common.Constants
import com.tencent.imsdk.TIMManager
import com.tencent.imsdk.TIMSdkConfig

class SplashActivity : AppCompatActivity() {
    private var mHandler : Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if (Constants.isFirst()){
                GuideActivity.startGuideActivity(this@SplashActivity)
                finish()
            }else{
                MainActivity.startMainActivity(this@SplashActivity)
                finish()
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        mHandler.sendEmptyMessageDelayed(1,2000)
    }
}
