package com.microple.jademall.ui.home.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.dialog.BuytypeDialog
import com.microple.jademall.dialog.PayDialog
import com.microple.jademall.ui.home.adapter.ImOrderAdapter
import kotlinx.android.synthetic.main.activity_im_order.*
import kotlinx.android.synthetic.main.item_title.*
import android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN



/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:立即下单
 */
class ImOrderActivity : AppCompatActivity() {
    var index:Int=1
    companion object {
        fun startImOrderActivity(context: Context){
            val intent = Intent(context, ImOrderActivity::class.java)
            context.startActivity(intent)
        }
    }
    lateinit var adapter:ImOrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_im_order)
        tv_title.text="立即下单"
         adapter= ImOrderAdapter(arrayListOf())
        var data = arrayListOf( "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_myOrder.layoutManager= LinearLayoutManager(this)
        rv_myOrder.isNestedScrollingEnabled = false
        rv_myOrder.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemChildClickListener { adapter, view, position ->
            if (view.id==R.id.ll_type){
                var dialog=BuytypeDialog(this)
                dialog.show()
                dialog.setOnBtnClickListener(object : BuytypeDialog.OnBtnClickListener {
                    override fun cancel(index: Int) {
                        dialog.dismiss()
                    }

                })
            }
        }
        tv_submint.setOnClickListener{
            var dialog=PayDialog(this)
            dialog.show()
            dialog.setOnBtnClickListener(object : PayDialog.OnBtnClickListener {
                override fun cancel(index: Int) {
                    dialog.dismiss()
                    PaySucceefulActivity.startPaySucceefulActivity(application)
                }

            })
        }
        tv_buy.setOnClickListener{
            adapter.upDateAdapter(index)
            if (index==1){
                index=0
            }else{
                index=1
            }
        }
    }
}
