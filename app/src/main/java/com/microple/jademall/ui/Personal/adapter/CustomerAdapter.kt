package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Customer
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/9/5
 * describe:
 */
class CustomerAdapter(data:List<Customer.ReturnsBean>):BaseQuickAdapter<Customer.ReturnsBean,BaseViewHolder>(R.layout.item_allorder) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: Customer.ReturnsBean?) {
        helper?.setText(R.id.tv_goodsName, item?.goods?.goods_name)
        helper?.setText(R.id.tv_goodsNum, item?.goods?.goods_sn)
        helper?.setText(R.id.tv_goodsPrice, "￥"+item?.goods?.goods_price)
        helper?.setText(R.id.tv_type,item?.status_desc)
        helper?.setText(R.id.tv_time,item?.add_time)
        helper?.getView<ImageView>(R.id.iv_goodsImage)?.loadImag(item?.goods?.goods_img!!)
    }
}