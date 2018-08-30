package com.microple.jademall.ui.search.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.microple.jademall.bean.Category
import com.microple.jademall.ui.search.SortGoodsFragment

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class SearchSortTabAdapter(fm: FragmentManager, var fragmentList: List<Fragment>, var titles: List<Category>) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? = titles[position].name

    override fun getItem(position: Int): Fragment {

        return  fragmentList[position] as SortGoodsFragment
    }

    override fun getCount(): Int = fragmentList.size
}