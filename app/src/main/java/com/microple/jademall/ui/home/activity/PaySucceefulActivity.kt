package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microple.jademall.MainActivity
import com.microple.jademall.R
import com.microple.jademall.common.App
import kotlinx.android.synthetic.main.activity_pay_succeeful.*
import kotlinx.android.synthetic.main.item_title.*

class PaySucceefulActivity : AppCompatActivity() {
    companion object {
        fun startPaySucceefulActivity(context: Context,order_sn:String,index:Int){
            val intent = Intent(context, PaySucceefulActivity::class.java)
            intent.putExtra("order_sn",order_sn)
            intent.putExtra("index",index)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_succeeful)
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
        if (intent.getIntExtra("index",0)==2){
            tv_title.text="取消成功"
            tv_title_c.text="取消订单成功，货款将原路退回！"
            tv_content.text="我们将退还您所支付的所有款项，再次感谢您对翡翠原石的信任!"
        }else{
            tv_title.text="支付成功"

        }
        tv_order.text="订单号：   "+intent.getStringExtra("order_sn")
        tv_back.setOnClickListener {
            (application as App).cleanActivity()
            MainActivity.startMainActivity(this)
            finish() }
        iv_back.setOnClickListener{
            (application as App).cleanActivity()
            MainActivity.startMainActivity(this)
            finish()
        }
    }
}
