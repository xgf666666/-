package com.microple.jademall.ui.search.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.SearchResult
import com.microple.jademall.ui.Personal.activity.AllOrderActivity
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.microple.jademall.ui.live.activity.LiveDetailsActivity
import com.microple.jademall.ui.search.adapter.SeacrhLiveAdapter
import com.microple.jademall.ui.search.adapter.SearchResultGoodsAdapter
import com.microple.jademall.ui.search.mvp.contract.SearchResultGoodsContract
import com.microple.jademall.ui.search.mvp.presenter.SearchResultGoodsPresenter
import com.xx.baseuilibrary.mvp.BaseMvpActivity
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_result_goods.*

/**
 * author: xiaoguangfei
 * date: 2018/8/7.
 * describe:搜索结果商品列表
 */
class SearchResultGoodsActivity : BaseMvpActivity<SearchResultGoodsPresenter>(),SearchResultGoodsContract.View{
    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): SearchResultGoodsPresenter = SearchResultGoodsPresenter()

    override fun getResult(searchResult: SearchResult) {
        loading.visibility=View.GONE
        if (searchResult.goods_list.size!=0){
            mAdapter.setNewData(searchResult.goods_list)
        }else{
            cardView.visibility=View.GONE
        }
        if (searchResult.live_list.size!=0){
            liveAdapter.setNewData(searchResult.live_list)
        }else{
            tv_live.visibility=View.GONE
        }
    }


    /**
     * 初始化数据状态
     */
    private var mAdapter = SearchResultGoodsAdapter(R.layout.item_goods)
    private var liveAdapter = SeacrhLiveAdapter()
    var name=""
    override fun initData() {
        name=intent.getStringExtra("name")
        getPresenter().getResult(name)
        tv_head.text=name
        tv_live.text="关于“${name}”的直播"
        mAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mAdapter
        recyclerView.isNestedScrollingEnabled=false
        liveAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        rv_live.layoutManager=LinearLayoutManager(this)
        rv_live.adapter=liveAdapter
        rv_live.isNestedScrollingEnabled=false
        mAdapter.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(this,(adapter as SearchResultGoodsAdapter).data[position].goods_sn)
        }
        liveAdapter.setOnItemClickListener { adapter, view, position ->
            LiveDetailsActivity.startLiveDetail(this, "" + (adapter as SeacrhLiveAdapter).data[position].live_id)
        }
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
        iv_back.setOnClickListener{finish()}
    }


    override fun getActivityLayoutId(): Int = R.layout.activity_result_goods
    companion object {
        fun startSearchResultGoodsActivity(context: Context,name:String){
            val intent = Intent(context, SearchResultGoodsActivity::class.java)
            intent.putExtra("name",name)
            context.startActivity(intent)
        }
    }


}