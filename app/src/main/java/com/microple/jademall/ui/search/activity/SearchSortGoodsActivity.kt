package com.microple.jademall.ui.search.activity

import android.support.v4.app.Fragment
import android.view.View
import com.microple.jademall.R
import com.microple.jademall.ui.search.SortGoodsFragment
import com.microple.jademall.ui.search.adapter.SearchSortTabAdapter
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_sort_goods.*
import java.util.ArrayList

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:搜索二级分类商品列表
 */
class SearchSortGoodsActivity : BaseMvpViewActivity(), View.OnClickListener {
    /**
     * 初始化数据状态
     */
    override fun initData() {
        val fragments = ArrayList<Fragment>()
        val titles = arrayOf("精品翡翠", "冰种翡翠", "任性赌石", "赌石亏光")
        for (i in titles.indices) {
            fragments.add(SortGoodsFragment())
        }
        viewPager.adapter = SearchSortTabAdapter(supportFragmentManager, fragments, titles)
        slidingTabLayout.setViewPager(viewPager)

        iv_back.setOnClickListener(this)
        tv_filtrate.setOnClickListener(this)
        tv_price.setOnClickListener(this)
        tv_hot.setOnClickListener(this)
        tv_newest.setOnClickListener(this)
    }

    /**
     * 初始化事件
     */
    override fun initEvent() {
    }

    private var isFiltrate = true

    override fun getActivityLayoutId(): Int = R.layout.activity_sort_goods



    override fun onClick(v: View?) {
        when (v) {
            iv_back -> finish()
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
}