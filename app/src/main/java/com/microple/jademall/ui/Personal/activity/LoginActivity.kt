package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:登录
 */
class LoginActivity : AppCompatActivity() {
    companion object {
        fun startLoginActivity(context: Context){
            val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tv_title.visibility= View.GONE
        tv_right.visibility=View.VISIBLE
        view_l.visibility=View.GONE
        tv_right.setOnClickListener{
            ForgetPWActivity.startForgetPWActivity(this)
        }
        tv_kuai.setOnClickListener{
            tv_kuai.setTextSize(17f)
            tv_kuai.setTextColor(resources.getColor(R.color.black_333333))
            tv_paswork.setTextColor(resources.getColor(R.color.green_06A366))
            tv_paswork.setTextSize(14f)
            tv_getcode.visibility=View.GONE
            et_code.hint="请输入验证码"
        }
        tv_paswork.setOnClickListener{
            tv_kuai.setTextSize(14f)
            tv_kuai.setTextColor(resources.getColor(R.color.green_06A366))
            tv_paswork.setTextColor(resources.getColor(R.color.black_333333))
            tv_paswork.setTextSize(17f)
            tv_getcode.visibility=View.GONE
            et_code.hint="密码"
        }
    }
}
