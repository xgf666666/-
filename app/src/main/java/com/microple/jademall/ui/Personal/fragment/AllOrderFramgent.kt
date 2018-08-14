package com.microple.jademall.ui.Personal.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.Personal.activity.OrderDetailActivity
import com.microple.jademall.ui.Personal.adapter.AllOrderAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_allorder.*
/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:
 */
class AllOrderFramgent :BaseMvpViewFragment(){
    var adapter = AllOrderAdapter(arrayListOf())

    /**
     * 获取Fragment的布局资源文件id
     */
    override fun getFragmentLayoutId(): Int = R.layout.fragment_allorder

    /**
     * 初始化
     */
    override fun init(view: View?) {
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.adapter=adapter
        adapter.addData(data)
        adapter.setOnItemClickListener { adapter, view, position ->
            OrderDetailActivity.startOrderDetailActivity(context!!)
        }
    }
}