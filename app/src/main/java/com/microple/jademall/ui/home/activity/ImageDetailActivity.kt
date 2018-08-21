package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.activity.IntergrationDetailActivity
import com.microple.jademall.ui.Personal.adapter.BillQueryAdapter
import com.microple.jademall.ui.Personal.adapter.ImageDetailAdapter
import kotlinx.android.synthetic.main.activity_image_detail.*
import kotlinx.android.synthetic.main.item_title.*

/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:商品详情图片
 */
class ImageDetailActivity : AppCompatActivity() {
    companion object {
        fun startImageDetailActivity(context: Context){
            val intent = Intent(context, ImageDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detail)
        tv_title.text="图片"
        var adapter= ImageDetailAdapter(arrayListOf())
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            IntergrationDetailActivity.startIntergrationDetailActivity(this)
        }
    }
}
