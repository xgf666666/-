package com.microple.jademall.ui.home

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.view.View
import android.widget.TextView
import com.bumptech.glide.Glide
import com.microple.jademall.common.Constant
import com.microple.jademall.R
import com.microple.jademall.bean.Category
import com.microple.jademall.bean.FirstImage
import com.microple.jademall.bean.Goods
import com.microple.jademall.common.Constants
import com.microple.jademall.ui.home.adapter.HomeTabAdapter
import com.microple.jademall.ui.home.fragment.BannerFragment
import com.microple.jademall.ui.home.mvp.contract.HomeContract
import com.microple.jademall.ui.home.mvp.presenter.HomePresenter
import com.microple.jademall.uitls.loadImag
import com.weibiaogan.bangbang.common.pxtodp
import com.xx.baseuilibrary.mvp.BaseMvpFragment
import com.xx.baseuilibrary.widget.CustPagerTransformer
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.collections.ArrayList

/**
 * author: linfeng
 * date: 2018/8/1.
 * describe:首页
 */
class HomeFragment : BaseMvpFragment<HomeContract.Model,HomeContract.View,HomePresenter>(),HomeContract.View, View.OnClickListener {



    /**
     * 创建P层
     *
     * @return P层对象
     */
    override fun createPresenter(): HomePresenter =HomePresenter()

    private var isFiltrate = true

    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun init(view: View?) {
//        setBackVisibility(false)
        //头像
//        Glide.with(context!!).load(Constant.item).into(iv_head)
        if (Constants.isLogin())
            iv_head.loadImag(Constants.getPersonal().head_img)
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
    override fun getCategory(data: List<Category>) {
        if (data.size!=0){
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
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id("price")
                }

            }
            tv_hot -> {
                setText(tv_hot)
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id("hot")
                }

            }
            tv_newest -> {
                setText(tv_newest)
                for (i:Int in 0..fragments.size-1){
                    (fragments[i] as HomeGoodsFragment).setCat_id("new")
                }
            }
        }
    }
    val fragments=ArrayList<Fragment>()
    private fun initGoodsData(data: List<Category>) {
        for (i in 0..data.size-1) {
            var fragment= HomeGoodsFragment()
            var bundle=Bundle()
            bundle.putInt("cat_id",data[i].cat_id)
            fragment.arguments=bundle
            fragments.add(fragment)
        }
        viewPagergGoods.adapter = HomeTabAdapter(this!!.fragmentManager!!, fragments, data)
        slidingTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE)
        slidingTabLayout.setupWithViewPager(viewPagergGoods)

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