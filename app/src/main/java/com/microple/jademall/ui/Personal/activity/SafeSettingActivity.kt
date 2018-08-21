package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_safe_setting.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:安全性设置
 */
class SafeSettingActivity : AppCompatActivity() {
    companion object {
        fun startSafeSettingActivity(context: Context){
            val intent = Intent(context, SafeSettingActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_safe_setting)
        tv_title.text="安全性设置"
        ll_login_password.setOnClickListener{
            PassswordActivity.startPassswordActivity(this,1)
        }
        ll_jiaoyu_password.setOnClickListener{
            PassswordActivity.startPassswordActivity(this,2)
        }
        ll_phone.setOnClickListener{
            PassswordActivity.startPassswordActivity(this,3)
        }
    }
}
