package com.microple.jademall.adapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.microple.jademall.ui.home.HomeGoodsFragment

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeTabAdapter(fm: FragmentManager, var fragmentList: List<Fragment>, var titles: Array<String>) : FragmentPagerAdapter(fm) {
    private lateinit var mFragment: HomeGoodsFragment
    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    override fun getItem(position: Int): Fragment {
        when(position){
            0->{//精品翡翠
                mFragment = fragmentList[position] as HomeGoodsFragment
            }
            1->{//冰种翡翠
                mFragment = fragmentList[position] as HomeGoodsFragment
            }
            2->{//任性赌石
                mFragment = fragmentList[position] as HomeGoodsFragment
            }
            3->{//赌石亏光
                mFragment = fragmentList[position] as HomeGoodsFragment
            }

        }
        return mFragment
    }

    override fun getCount(): Int = fragmentList.size
}