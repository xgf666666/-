package com.microple.jademall.ui.Personal.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import kotlinx.android.synthetic.main.fragment_allorder.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:待收货订单
 */
class NotGoodsOrderActivity : AppCompatActivity() {
    var adapter = AllOrderAdapter(arrayListOf())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_not_goods_order)
        tv_title.text="待收货订单"
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
