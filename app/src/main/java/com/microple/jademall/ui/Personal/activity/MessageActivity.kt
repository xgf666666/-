package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.BillQueryAdapter
import com.microple.jademall.ui.Personal.adapter.MessageAdapter
import kotlinx.android.synthetic.main.activity_complete_order.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:消息列表 */
class MessageActivity : AppCompatActivity() {
    companion object {
        fun startMessageActivity(context: Context){
            val intent = Intent(context,MessageActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        tv_title.text="消息列表"
        var adapter= MessageAdapter(arrayListOf())
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            MessageDetailActivity.startMessageDetailActivity(this)
        }
    }
}
