package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
        fun startCustomerListActivity(context: Context,order_id:String,goods_name:String,goods_sn:String,goods_price:String,goods_img:String,goods_id:String){
            val intent = Intent(context,ApplyCustomerActivity::class.java)
            intent.putExtra("order_id",order_id)
            intent.putExtra("goods_name",goods_name)
            intent.putExtra("goods_sn",goods_sn)
            intent.putExtra("goods_price",goods_price)
            intent.putExtra("goods_img",goods_img)
            intent.putExtra("goods_id",goods_id)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_list)
        tv_title.text="申请售后"
        ll_jilu.setOnClickListener{
            SureCustomerActivity.startCustomerActivity(this,intent.getStringExtra("order_id")
            ,intent.getStringExtra("goods_name")
                    ,intent.getStringExtra("goods_sn")
                    ,intent.getStringExtra("goods_price")
                    ,intent.getStringExtra("goods_img")
                    ,intent.getStringExtra("goods_id"))
            finish()
        }
        ll_shenqing.setOnClickListener{
            SureCustomerActivity.startCustomerActivity(this,intent.getStringExtra("order_id")
                    ,intent.getStringExtra("goods_name")
                    ,intent.getStringExtra("goods_sn")
                    ,intent.getStringExtra("goods_price")
                    ,intent.getStringExtra("goods_img")
                    ,intent.getStringExtra("goods_id"))
            finish()
        }
    }
}
