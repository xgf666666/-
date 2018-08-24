package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:忘记密码
 */
class ForgetPWActivity : AppCompatActivity() {
    companion object {
        fun startForgetPWActivity(context: Context){
            val intent = Intent(context, ForgetPWActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_pw)
        tv_title.text="忘记密码"
        view_l.visibility= View.GONE
    }
}
