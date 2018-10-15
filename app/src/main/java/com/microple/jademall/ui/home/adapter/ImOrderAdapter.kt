package com.microple.jademall.ui.home.adapter

import android.support.v4.widget.SlidingPaneLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.ImOrder
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class ImOrderAdapter(data:List<ImOrder.OrderBean.GoodsInfoBean>):BaseQuickAdapter<ImOrder.OrderBean.GoodsInfoBean,BaseViewHolder>(R.layout.item_imadapter,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    var indexs=0
    fun upDateAdapter(index:Int){
        indexs=index
        notifyDataSetChanged()
    }
    override fun convert(helper: BaseViewHolder?, item: ImOrder.OrderBean.GoodsInfoBean) {
        helper?.setText(R.id.tv_goodsName, item.goods_name)
        helper?.setText(R.id.tv_goodsNum, item.goods_sn)
        helper?.setText(R.id.tv_goodsPrice, "￥"+item.goods_price)
        helper?.getView<ImageView>(R.id.iv_goodsImage)?.loadImag(item.goods_img)
        if (indexs==1){
            helper?.getView<SlidingPaneLayout>(R.id.slide)?.openPane()
        }else{
            helper?.getView<SlidingPaneLayout>(R.id.slide)?.closePane()
        }
        helper?.addOnClickListener(R.id.ll_type)

    }
}