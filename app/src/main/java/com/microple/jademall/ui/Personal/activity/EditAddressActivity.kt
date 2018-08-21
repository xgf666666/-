package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:编辑收货地址
 */
class EditAddressActivity : AppCompatActivity() {
    companion object {
        fun startEditAddressActivity(context: Context){
            val intent = Intent(context, EditAddressActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)
    }
}
