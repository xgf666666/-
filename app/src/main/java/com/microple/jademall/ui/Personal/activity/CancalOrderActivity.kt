package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import kotlinx.android.synthetic.main.activity_cancal_order.*
import kotlinx.android.synthetic.main.item_title.*
/**
* author: xiaoguagnfei
* date: 2018/8/13
* describe:已取消订单
*/
class CancalOrderActivity : AppCompatActivity() {

    companion object {
        fun startCancalOrderActivity(context: Context){
            val intent = Intent(context,CancalOrderActivity::class.java)
            context.startActivity(intent)
        }
    }

    var adapter = AllOrderAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancal_order)
        tv_title.text="已取消订单"
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetailActivity(this!!)
        }
    }
}
