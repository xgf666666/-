package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_my_asset.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:我的资产
 */
class MyAssetActivity : AppCompatActivity() {
    companion object {
        fun startMyAssetActivity(context: Context){
            val intent = Intent(context,MyAssetActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_asset)
        tv_title.setText("我的资产")
        tv_detail.setOnClickListener{
            BillQueryActivity.startBillQueryActivity(this)
        }
        tv_zhuangzhang.setOnClickListener{
            IntergrationPushActivity.startIntergrationPushActivity(this)
        }
        tv_feicui.setOnClickListener{
            EmeraldsActivity.startEmeraldsActivity(this)
        }
    }
}
