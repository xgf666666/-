package com.microple.jademall.ui.search

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.search.activity.SearchResultGoodsActivity
import com.microple.jademall.ui.search.adapter.SearchGoodsAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_goods.view.*

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:二级分类商品列表
 */
class SortGoodsFragment : BaseMvpViewFragment(),BaseQuickAdapter.OnItemClickListener{


    private lateinit var mRootView : View

    private var mAdapter = SearchGoodsAdapter(R.layout.item_goods)

    override fun getFragmentLayoutId(): Int = R.layout.fragment_goods

    override fun init(view: View?) {
        mRootView = view!!
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        mRootView.recyclerView.adapter = mAdapter
        mRootView.recyclerView.layoutManager= LinearLayoutManager(context)
        mAdapter.addData(data)
        mAdapter.notifyDataSetChanged()
        mAdapter.setOnItemClickListener(this)

    }
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        startActivity(Intent(context,SearchResultGoodsActivity::class.java))
    }
}