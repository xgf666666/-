package com.microple.jademall.ui.shoppingcar

import android.view.View
import com.microple.jademall.R
import com.microple.jademall.common.Constant
import com.xx.baseuilibrary.mvp.BaseMvpViewFragment

/**
 * author: linfeng
 * date: 2018/8/8.
 * describe:购物车
 */
class ShoppingCarFragment : BaseMvpViewFragment(){
    override fun getFragmentLayoutId(): Int = R.layout.fragment_shoppingcar

    override fun init(view: View?) {
        setTitle("购物袋")
        setHeadImage(Constant.item)
    }
}