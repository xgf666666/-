package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Order
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/8/14
 * describe:
 */
class AllOrderAdapter(data:List<Order.OrderListBean>):BaseQuickAdapter<Order.OrderListBean,BaseViewHolder>(R.layout.item_allorder,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.ffff
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Order.OrderListBean?) {
        helper?.setText(R.id.tv_goodsName, item?.goods_info?.goods_name)
        helper?.setText(R.id.tv_goodsNum, item?.goods_info?.goods_sn)
        helper?.setText(R.id.tv_goodsPrice, "￥"+item?.goods_info?.goods_price)
        helper?.setText(R.id.tv_type,item?.status_desc)
        helper?.setText(R.id.tv_time,"下单时间:  "+item?.add_time)
        helper?.getView<ImageView>(R.id.iv_goodsImage)?.loadImag(item?.goods_info?.goods_img!!)
    }


}