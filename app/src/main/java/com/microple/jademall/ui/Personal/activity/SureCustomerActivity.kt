package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:确认售后申请
 */
class SureCustomerActivity : AppCompatActivity() {
    companion object {
        fun startCustomerActivity(context: Context){
            val intent = Intent(context,SureCustomerActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        tv_title.text="确认售后申请"
    }
}
