package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_customer_list.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:申请售后
 */
class ApplyCustomerActivity : AppCompatActivity() {
    companion object {
        fun startCustomerListActivity(context: Context){
            val intent = Intent(context,ApplyCustomerActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_list)
        tv_title.text="申请售后"
        ll_jilu.setOnClickListener{
            SureCustomerActivity.startCustomerActivity(this)
        }
        ll_shenqing.setOnClickListener{
            SureCustomerActivity.startCustomerActivity(this)
        }
    }
}
