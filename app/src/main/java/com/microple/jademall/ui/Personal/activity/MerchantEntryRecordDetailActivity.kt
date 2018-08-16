package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.microple.jademall.R
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻申请记录详情
 */
class MerchantEntryRecordDetailActivity : AppCompatActivity() {
    companion object {
        fun startMerchantEntryRecordDetailActivity(context: Context){
            val intent = Intent(context,MerchantEntryRecordDetailActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant_entry_record_detail)
        tv_title.text="商家入驻申请记录详情"
    }
}
