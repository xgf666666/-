package com.microple.jademall.ui.live.activity

import android.support.v7.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.ui.live.mvp.contract.LiveGoodsContract
import com.microple.jademall.ui.live.mvp.presenter.LiveGoodsPresenter
import com.microple.jademall.ui.search.adapter.SearchResultGoodsAdapter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_live_goods.*
import kotlinx.android.synthetic.main.item_title.*

class LiveGoodsActivity : BaseMvpActivity<LiveGoodsPresenter>(),LiveGoodsContract.View {
    /**
     * 获取布局资源文件id
     *
     * @return 布局资源文件id
     */
    override fun getActivityLayoutId(): Int =R.layout.activity_live_goods

    /**
     * 初始化数据状态
     */
    private var mAdapter = SearchResultGoodsAdapter(R.layout.item_goods)
    override fun initData() {
        tv_title.text="直播间商品"
        iv_back.setOnClickListener {finish()}
        var data = arrayListOf("", "", "")
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        mAdapter.addData(data)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): LiveGoodsPresenter =LiveGoodsPresenter()

}
