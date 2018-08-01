package com.microple.jademall.ui.home

import android.view.View
import com.microple.jademall.R
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment

/**
 * author: linfeng
 * date: 2018/8/1.
 * describe:
 */
class HomeFragment : BaseMvpViewFragment(){
    override fun getFragmentLayoutId(): Int = R.layout.fragment_home

    override fun init(view: View?) {
        setTitle("3H翡翠商城")
        setBackVisibility(false)
    }
}