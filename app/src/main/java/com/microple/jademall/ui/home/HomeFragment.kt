package com.microple.jademall.ui.home

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.View
import com.bumptech.glide.Glide
import com.microple.jademall.base.Constant
import com.microple.jademall.R
import com.microple.jademall.adapter.HomeTabAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment
import com.xx.baseuilibrary.widget.CustPagerTransformer
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.ArrayList

/**
 * author: linfeng
 * date: 2018/8/1.
 * describe:
 */
class HomeFragment : BaseMvpViewFragment(), View.OnClickListener {

    private var isFiltrate = true
    private val fragments = ArrayList<BannerFragment>() // 供ViewPager使用
    private val imageList = arrayOf(Constant.item, Constant.item, Constant.item, Constant.item, Constant.item)
    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun init(view: View?) {
        setBackVisibility(false)
        //头像
        Glide.with(context!!).load(Constant.item).into(iv_head)
        // 3. 填充ViewPager
        fillViewPager()
        //商品列表
        initGoodsData()
        tv_filtrate.setOnClickListener(this)
        tv_price.setOnClickListener(this)
        tv_hot.setOnClickListener(this)
        tv_newest.setOnClickListener(this)
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
                tv_price.setTextColor(resources.getColor(R.color.colorMain))
                tv_hot.setTextColor(resources.getColor(R.color.text_black))
                tv_newest.setTextColor(resources.getColor(R.color.text_black))

            }
            tv_hot -> {
                tv_hot.setTextColor(resources.getColor(R.color.colorMain))
                tv_price.setTextColor(resources.getColor(R.color.text_black))
                tv_newest.setTextColor(resources.getColor(R.color.text_black))
            }
            tv_newest -> {
                tv_newest.setTextColor(resources.getColor(R.color.colorMain))
                tv_price.setTextColor(resources.getColor(R.color.text_black))
                tv_hot.setTextColor(resources.getColor(R.color.text_black))
            }
        }
    }

    private fun initGoodsData() {
        val fragments = ArrayList<Fragment>()
        val titles = arrayOf("精品翡翠", "冰种翡翠", "任性赌石", "赌石亏光")
        for (i in titles.indices) {
            fragments.add(HomeGoodsFragment())
        }
        viewPagergGoods.adapter = HomeTabAdapter(this!!.fragmentManager!!, fragments, titles)
        slidingTabLayout.setViewPager(viewPagergGoods)

    }

    private fun fillViewPager() {
        // 1. viewPager添加parallax效果，使用PageTransformer就足够了
        viewPager.setPageTransformer(false, CustPagerTransformer(context))
        viewPager.pageMargin = 26
        // 2. viewPager添加adapter
        for (i in 0..9) {
            // 预先准备10个fragment
            fragments.add(BannerFragment())
        }
        viewPager.adapter = object : FragmentStatePagerAdapter(fragmentManager) {
            override fun getItem(position: Int): Fragment? {
                val fragment = fragments[position % 10]
                fragment.setImageUrl(imageList[position % imageList.size])
                return fragment
            }

            override fun getCount(): Int {
                return fragments.size
            }
        }
    }

}