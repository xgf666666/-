package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_customer_service_acitivity.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:联系客服
 */
class CustomerServiceAcitivity : AppCompatActivity() {
    
    companion object {
        fun startCustomerServiceAcitivity(context: Context){
            val intent = Intent(context,CustomerServiceAcitivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_service_acitivity)
        tv_title.text="联系客服"
        tv_phone.setOnClickListener{
            val uri = Uri.parse("tel:"+"66666666")
            val it = Intent(Intent.ACTION_DIAL, uri)
            startActivity(it)
        }
        iv_back.setOnClickListener{
            finish()
        }
    }
}
