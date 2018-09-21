package com.microple.jademall

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.microple.jademall.common.Constants

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
