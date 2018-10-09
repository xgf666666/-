package com.microple.jademall.ui.Personal.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.OrderDetail

/**
 * author: xiaoguagnfei
 * date: 2018/9/7
 * describe:
 */
class LogisticalAdapter(data:List<OrderDetail.OrderDetailBean.LogisticsBean>):BaseQuickAdapter<OrderDetail.OrderDetailBean.LogisticsBean,BaseViewHolder>(R.layout.item_logistical) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: OrderDetail.OrderDetailBean.LogisticsBean?) {
        helper?.setText(R.id.tv_content,"【${item?.time}】"+item?.context)
//        helper?.setText(R.id.tv_content,item?.time+item?.context)
    }
}