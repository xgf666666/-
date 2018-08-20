package com.microple.jademall.ui.shoppingcar.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R

/**
 * author: xiaoguagnfei
 * date: 2018/8/17
 * describe:
 */
class LeftAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_left,data) {

    override fun convert(helper: BaseViewHolder?, item: String?) {

    }
}