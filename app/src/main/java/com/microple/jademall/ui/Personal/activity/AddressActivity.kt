package com.microple.jademall.ui.Personal.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.adapter.AddressAdapter
import kotlinx.android.synthetic.main.item_title.*
import kotlinx.android.synthetic.main.activity_address.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/13
 * describe:管理收货地址
 */
class AddressActivity : AppCompatActivity() {
    companion object {
        fun startAddressActivity(context: Context){
            val intent = Intent(context, AddressActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)
        tv_title.text="管理收货地址"
        var adapter= AddressAdapter(arrayListOf())
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemChildClickListener { adapter, view, position ->
            when(view.id){
                R.id.tv_bianji->{
                    EditAddressActivity.startEditAddressActivity(this)
                }
                R.id.tv_del->{
                    adapter.remove(position)
                }
                R.id.tv_setting->{}
            }
        }
    }
}
