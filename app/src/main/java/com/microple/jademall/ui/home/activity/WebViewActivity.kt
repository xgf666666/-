package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : BaseMvpViewActivity() {
    /**
     * 初始化数据状态
     */
    override fun initData() {
        webView.loadUrl(intent.getStringExtra("url"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_web_view

    companion object {
        fun startLivePlayerActivity(context: Context,url:String){
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url",url)
            context.startActivity(intent)
        }
    }

}
