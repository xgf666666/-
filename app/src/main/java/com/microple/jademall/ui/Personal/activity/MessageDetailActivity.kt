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
 * describe:消息详情
 */
class MessageDetailActivity : AppCompatActivity() {
    companion object {
        fun startMessageDetailActivity(context: Context){
            val intent = Intent(context,MessageDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message_detail)
        tv_title.text="消息详情"
    }
}
