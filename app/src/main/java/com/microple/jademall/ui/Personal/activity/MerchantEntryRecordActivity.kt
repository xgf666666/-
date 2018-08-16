package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.MerchantEntryRecordAdapter
import kotlinx.android.synthetic.main.activity_merchant_entry_record.*
import kotlinx.android.synthetic.main.item_title.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商家入驻申请记录
 */
class MerchantEntryRecordActivity : AppCompatActivity() {
    companion object {
        fun startMerchantEntryRecordActivity(context: Context){
            val intent = Intent(context,MerchantEntryRecordActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant_entry_record)
        tv_title.text="商家入驻申请记录"
        var adapter= MerchantEntryRecordAdapter(arrayListOf())
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        var data = arrayListOf( "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            MerchantEntryRecordDetailActivity.startMerchantEntryRecordDetailActivity(this)

        }
    }
}
