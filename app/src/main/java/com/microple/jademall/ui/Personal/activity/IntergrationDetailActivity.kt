package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguangfei
 * date: 2018/8/8.
 * describe:积分详情
 */
class IntergrationDetailActivity : AppCompatActivity() {
    companion object {
        fun startIntergrationDetailActivity(context: Context){
            val intent = Intent(context,IntergrationDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intergration_detail)
        tv_title.text="账单查询"
    }
}
