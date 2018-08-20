package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:意见反馈
 */
class FeedBackActivity : AppCompatActivity() {
    companion object {
        fun startFeedBackActivity(context: Context){
            val intent = Intent(context,FeedBackActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_back)
        tv_title.text="意见反馈"
    }
}
