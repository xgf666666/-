package com.microple.jademall.ui.search.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.search.adapter.SearchResultGoodsAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_result_goods.*

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:搜索结果商品列表
 */
class SearchResultGoodsActivity : BaseMvpViewActivity(), View.OnClickListener{

    private var mAdapter = SearchResultGoodsAdapter(R.layout.item_goods)

    override fun getActivityLayoutId(): Int = R.layout.activity_result_goods

    override fun init() {
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        mAdapter.addData(data)
        mAdapter.notifyDataSetChanged()
        iv_back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            iv_back -> finish()
        }
    }
}