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
 * describe:售后订单详情
 */
class CusetomerOrderDetailActivity : AppCompatActivity() {
    companion object {
        fun startCusetomerOrderDetailActivity(context: Context){
            val intent = Intent(context,CusetomerOrderDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cusetomer_order_detail)
        tv_title.text="售后订单详情"

    }
}
