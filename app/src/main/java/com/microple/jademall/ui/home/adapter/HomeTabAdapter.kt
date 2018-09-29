package com.microple.jademall.ui.home.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import com.microple.jademall.bean.Category
import com.microple.jademall.bean.TwoSearch
import com.microple.jademall.ui.home.HomeGoodsFragment

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeTabAdapter(fm: FragmentManager, var fragmentList: List<Fragment>, var titles: List<TwoSearch.SecCatesBean>) : FragmentPagerAdapter(fm) {
    override fun getPageTitle(position: Int): CharSequence? = titles[position].name

    override fun getItem(position: Int): Fragment {
        return  fragmentList[position] as HomeGoodsFragment
    }

    override fun getCount(): Int = fragmentList.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }
}