package com.microple.jademall.ui.home

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Goods
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.microple.jademall.ui.home.adapter.HomeGoodsAdapter
import com.microple.jademall.ui.home.mvp.contract.HomeGoodsContract
import com.microple.jademall.ui.home.mvp.presenter.HomeGoodsPresenter
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_goods.*
/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeGoodsFragment : BaseMvpFragment<HomeGoodsContract.Model,HomeGoodsContract.View,HomeGoodsPresenter>(),HomeGoodsContract.View, BaseQuickAdapter.RequestLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    /**
     * 创建P层
     *
     * @return P层对象
     */
    var catId:Int=0
    var current:Int=1
    var sort:String=""
    override fun createPresenter(): HomeGoodsPresenter = HomeGoodsPresenter()

    override fun getFragmentLayoutId(): Int = R.layout.fragment_goods
    var data:Goods= Goods()
    var mAdapter:HomeGoodsAdapter?=null
    override fun init(view: View?) {
        var bundle=arguments
        catId=bundle!!.getInt("cat_id")
         mAdapter = HomeGoodsAdapter(arrayListOf())
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager= LinearLayoutManager(context)
        mAdapter?.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        mAdapter?.setOnLoadMoreListener(this,recyclerView)
        mAdapter?.disableLoadMoreIfNotFullPage()
        swipeRefreshLayout.setOnRefreshListener(this)
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(context!!,(adapter as HomeGoodsAdapter).data[position].goods_sn)
        }
        getPresenter().getGoodList(catId,current,sort)

    }
    //首页商品列表返回值
    override fun getGoodList(data:Goods) {
        this.data=data
        if (swipeRefreshLayout.isRefreshing){
            mAdapter?.setNewData(data.goods_list)
            swipeRefreshLayout.isRefreshing=false
            mAdapter?.notifyDataSetChanged()
        }else if (mAdapter?.isLoading!!){
            mAdapter?.addData(data.goods_list)
            mAdapter?.loadMoreComplete()
            mAdapter?.notifyDataSetChanged()
        }else {
            mAdapter?.setNewData(data.goods_list)
            mAdapter?.notifyDataSetChanged()
        }
        if (data.goods_list.size==0){
            mAdapter?.loadMoreEnd()
        }
        Log.i("currentssss","current"+current)

    }
    //上拉加载
    override fun onLoadMoreRequested() {
        current++
        getPresenter().getGoodList(catId,current,sort)
    }
    /***
    下拉刷新
     */
    override fun onRefresh() {
        current=1
        getPresenter().getGoodList(catId,current,sort)
    }
      fun setCat_id(sort:String){
        this.sort=sort
          current=1
        getPresenter().getGoodList(catId,current,sort)

    }
}