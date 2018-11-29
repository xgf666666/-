package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import com.microple.jademall.R
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_web_view.*
import kotlinx.android.synthetic.main.item_title.*

class WebViewActivity : BaseMvpViewActivity() {
    /**
     * 初始化数据状态
     */
    override fun initData() {
        tv_title.text = intent.getStringExtra("name")
        webView.loadUrl(intent.getStringExtra("url"))
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener { finish() }
    }

    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int = R.layout.activity_web_view

    companion object {
        fun startLivePlayerActivity(context: Context, url: String, name: String) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("url", url)
            intent.putExtra("name", name)
            context.startActivity(intent)
        }
    }

}
