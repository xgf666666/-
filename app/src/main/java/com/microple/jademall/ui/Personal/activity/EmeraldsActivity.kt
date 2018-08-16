package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.EmealdsAdapter
import kotlinx.android.synthetic.main.activity_cancal_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:翡翠柜
 */
class EmeraldsActivity : AppCompatActivity() {
    companion object {
        fun startEmeraldsActivity(context: Context){
            val intent = Intent(context,EmeraldsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emeralds)
        tv_title.text="翡翠柜"
        var adapter= EmealdsAdapter(arrayListOf())
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= GridLayoutManager(this,2)
        recyclerView.adapter=adapter
        var data = arrayListOf( "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            EmeraldsDetailActivity.startOrderDetailActivity(this!!)
        }
    }
}
