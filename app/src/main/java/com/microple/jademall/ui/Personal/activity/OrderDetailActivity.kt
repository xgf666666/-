package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_order_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
* author: xiaoguagnfei
* date: 2018/8/14
* describe:订单详情
*/
class OrderDetailActivity : AppCompatActivity() {
    companion object {
        fun startOrderDetailActivity(context: Context){
            val intent = Intent(context,OrderDetailActivity::class.java)
            context.startActivity(intent)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        tv_title.text="订单详情"
        tv_order.setOnClickListener{
            CustomerActivity.startCustomerActivity(this)
        }
    }
}
