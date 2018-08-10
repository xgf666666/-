package com.microple.jademall.ui.home

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.home.adapter.HomeGoodsAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_goods.view.*

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeGoodsFragment : BaseMvpViewFragment() {
    private lateinit var mRootView : View
    private var mAdapter = HomeGoodsAdapter(R.layout.item_goods)
    override fun getFragmentLayoutId(): Int = R.layout.fragment_goods


    override fun init(view: View?) {
        mRootView = view!!
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        mRootView.recyclerView.adapter = mAdapter
        mRootView.recyclerView.layoutManager= LinearLayoutManager(context)
        mAdapter.addData(data)
        mAdapter.notifyDataSetChanged()
    }
}