package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.activity_merchant_entry.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻
 */
class MerchantEntryActivity : AppCompatActivity() {
    companion object {
        fun startMerchantEntryActivity(context: Context){
            val intent = Intent(context,MerchantEntryActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant_entry)
        tv_title.text="商家入驻"
        ll_jilu.setOnClickListener{
            MerchantEntryRecordActivity.startMerchantEntryRecordActivity(this)
        }
        ll_shenqing.setOnClickListener{
//            ApplicationActivity.startApplicationActivity(this)
            NeedNoteActivity.startNeedNoteActivity(this)
        }
    }
}
