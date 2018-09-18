package com.microple.jademall.ui.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.microple.jademall.R
import com.microple.jademall.bean.Category
import com.microple.jademall.bean.FirstImage
import com.microple.jademall.bean.Goods
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.home.activity.GoodsDetailActivity
import com.microple.jademall.ui.home.adapter.HomeGoodsAdapter
import com.microple.jademall.ui.home.fragment.BannerFragment
import com.microple.jademall.ui.home.mvp.contract.HomeContract
import com.microple.jademall.ui.home.mvp.presenter.HomePresenter
import com.microple.jademall.uitls.loadHeadImag
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import com.xx.baseuilibrary.widget.CustPagerTransformer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.collections.ArrayList

/**
 * author: linfeng
 * date: 2018/8/1.
 * describe:首页
 */
class HomeFragment : BaseMvpFragment<HomeContract.Model,HomeContract.View,HomePresenter>(),HomeContract.View, View.OnClickListener , SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener, TabLayout.OnTabSelectedListener {

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }


    override fun onTabUnselected(tab: TabLayout.Tab?) {
    }


    override fun onTabSelected(tab: TabLayout.Tab?) {
        current=1
        catId=dataCategory!![tab?.position!!].cat_id
        getPresenter().getGoodList(dataCategory!![tab?.position!!].cat_id,current,sort)
    }

    override fun onLoadMoreRequested() {
        current++
        getPresenter().getGoodList(catId,current,sort)
    }

    /**
     * Called when a swipe gesture triggers a refresh.
     */
    override fun onRefresh() {
        current=1
        getPresenter().getGoodList(catId,current,sort)
    }

    var data:Goods= Goods()
    var catId:Int=0
    var current:Int=1
    var sort:String=""
    override fun getGoodList(data: Goods) {
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


    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): HomePresenter =HomePresenter()

    private var isFiltrate = true

    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun init(view: View?) {
        if (Constants.isLogin())
            iv_head.loadHeadImag(Constants.getPersonal().head_img)
        showLoadingDialog()
        getPresenter().getFirstView()
        getPresenter().getCategory()


        tv_filtrate.setOnClickListener(this)
        tv_price.setOnClickListener(this)
        tv_hot.setOnClickListener(this)
        tv_newest.setOnClickListener(this)
    }
    //轮播图
    override fun getFirstView(data: List<FirstImage>) {
        // 3. 填充ViewPager
        fillViewPager(data)
        dismissLoadingDialog()
    }
    //首页一级分类
    var dataCategory: List<Category>?=null
    override fun getCategory(data: List<Category>) {
        if (data.size!=0){
            dataCategory=data
            initGoodsData(data)
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            tv_filtrate -> {
                if (isFiltrate) {
                    ll_filtrate.visibility = View.VISIBLE
                    isFiltrate = !isFiltrate
                } else {
                    ll_filtrate.visibility = View.GONE
                    isFiltrate = !isFiltrate
                }
            }
            tv_price -> {
                setText(tv_price)
                current=1
                sort="price"
                getPresenter().getGoodList(catId,current,"price")

            }
            tv_hot -> {
                setText(tv_hot)
                current=1
                sort="hot"
                getPresenter().getGoodList(catId,current,"hot")

            }
            tv_newest -> {
                setText(tv_newest)
                current=1
                sort="new"
                getPresenter().getGoodList(catId,current,"new")
            }
        }
    }
    var mAdapter=HomeGoodsAdapter(arrayListOf())
    private fun initGoodsData(data: List<Category>) {
        getPresenter().getGoodList(data[0].cat_id,current,sort)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager= LinearLayoutManager(context)
        recyclerView.isNestedScrollingEnabled=false
        mAdapter?.openLoadAnimation(BaseQuickAdapter.SCALEIN)
        mAdapter?.setOnLoadMoreListener(this,recyclerView)
        mAdapter?.disableLoadMoreIfNotFullPage()
        swipeRefreshLayout.setOnRefreshListener(this)
        for (i in 0..data.size-1){
            slidingTabLayout.addTab(slidingTabLayout.newTab().setText(data[i].name))
        }
        slidingTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE)
        slidingTabLayout.addOnTabSelectedListener(this)
        mAdapter?.setOnItemClickListener { adapter, view, position ->
            GoodsDetailActivity.startGoodsDetailActivity(context!!,(adapter as HomeGoodsAdapter).data[position].goods_sn)
        }
    }

    private fun fillViewPager(data:List<FirstImage>) {
        // 1. viewPager添加parallax效果，使用PageTransformer就足够了
        val fragments = ArrayList<BannerFragment>() // 供ViewPager使用
        viewPager.setPageTransformer(false, CustPagerTransformer(context))
        viewPager.pageMargin = 26
        // 2. viewPager添加adapter
        for (i in 0..data.size-1) {
            var fragment= BannerFragment()
            var bundle=Bundle()
            bundle.putString("img",data[i].img)
            bundle.putInt("banner_id",data[i].banner_id)
            fragment.arguments=bundle
            fragments.add(fragment)
        }
        viewPager.adapter = object : FragmentStatePagerAdapter(fragmentManager) {
            override fun getItem(position: Int): Fragment? {
                val fragment = fragments[position ]
                return fragment
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
    }
    fun setText(textView: TextView){
        tv_newest.setTextColor(resources.getColor(R.color.text_black))
        tv_price.setTextColor(resources.getColor(R.color.text_black))
        tv_hot.setTextColor(resources.getColor(R.color.text_black))
        tv_newest.isEnabled=true
        tv_price.isEnabled=true
        tv_hot.isEnabled=true
        textView.isEnabled=false
        textView.setTextColor(resources.getColor(R.color.colorMain))

    }


}