package com.microple.jademall.ui.search

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.common.Constant
import com.microple.jademall.ui.search.activity.SearchSortGoodsActivity
import com.microple.jademall.ui.search.adapter.SearchSortAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import kotlinx.android.synthetic.main.fragment_search.*

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:搜索
 */
class SearchFragment : BaseMvpViewFragment(),BaseQuickAdapter.OnItemClickListener {


    private var mAdapter = SearchSortAdapter(R.layout.item_search_sort)

    override fun getFragmentLayoutId(): Int = R.layout.fragment_search

    override fun init(view: View?) {
        setTitle("搜索")
        setHeadImage(Constant.item)
        var data = arrayListOf("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = mAdapter
        mAdapter.addData(data)
        mAdapter.notifyDataSetChanged()
        mAdapter.setOnItemClickListener(this)
    }
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        startActivity(Intent(context,SearchSortGoodsActivity::class.java))
    }
}