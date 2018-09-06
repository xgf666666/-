package com.microple.jademall.ui.Personal.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.microple.jademall.bean.Category

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:
 */
class ViewPagerAdapter(fm: FragmentManager, var fragmentList: List<Fragment>,var titles: List<String>):FragmentPagerAdapter(fm) {
    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment =fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? =titles[position]

    /**
     * Return the number of views available.
     */
    override fun getCount(): Int =fragmentList.size
}