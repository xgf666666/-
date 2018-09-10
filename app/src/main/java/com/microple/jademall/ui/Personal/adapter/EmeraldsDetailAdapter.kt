package com.microple.jademall.ui.Personal.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Profit

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class EmeraldsDetailAdapter(data:List<Profit.ProfitsBean>):BaseQuickAdapter<Profit.ProfitsBean,BaseViewHolder>(R.layout.item_emeralds_detail,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Profit.ProfitsBean?) {
        helper?.setText(R.id.tv_time,item?.add_time)
        helper?.setText(R.id.tv_zichan,item?.points)
    }
}