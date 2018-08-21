package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_passsword.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:修改密码跟电话
 */
class PassswordActivity : AppCompatActivity() {
    var flags=0//1设置登录密码2设置交易密码3修改手机号码
    companion object {
        fun startPassswordActivity(context: Context,flag:Int){
            val intent = Intent(context, PassswordActivity::class.java)
            intent.putExtra("flag",flag)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passsword)
        flags=intent.getIntExtra("flag",0)
        when(flags){
            1->{
                tv_title.text="设置/修改登录密码"
            }
            2->{
                tv_newpasw.text="新交易密码"
                tv_title.text="设置/修改交易密码"
            }
            3->{
                tv_title.text="修改手机号码"
                tv_newpasw.text="新手机号码"
                et_password.hint="请输入新手机号码"
                tv_newpasw.inputType=InputType.TYPE_CLASS_NUMBER
            }
        }
    }
}
