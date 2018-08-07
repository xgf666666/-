package com.microple.jademall.ui.search.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.microple.jademall.ui.search.SortGoodsFragment

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class SearchSortTabAdapter(fm: FragmentManager, var fragmentList: List<Fragment>, var titles: Array<String>) : FragmentPagerAdapter(fm) {
    private lateinit var mFragment: SortGoodsFragment
    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{//精品翡翠
                mFragment = fragmentList[position] as SortGoodsFragment
            }
            1->{//冰种翡翠
                mFragment = fragmentList[position] as SortGoodsFragment
            }
            2->{//任性赌石
                mFragment = fragmentList[position] as SortGoodsFragment
            }
            3->{//赌石亏光
                mFragment = fragmentList[position] as SortGoodsFragment
            }

        }
        return mFragment
    }

    override fun getCount(): Int = fragmentList.size
}