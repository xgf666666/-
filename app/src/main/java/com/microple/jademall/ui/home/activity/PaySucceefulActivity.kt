package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*

class PaySucceefulActivity : AppCompatActivity() {
    companion object {
        fun startPaySucceefulActivity(context: Context){
            val intent = Intent(context, PaySucceefulActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_succeeful)
        tv_title.text="支付成功"
    }
}
