package com.microple.jademall.ui.shoppingcar.adapter

import android.support.v4.widget.SlidingPaneLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Shop
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class ShoppingAdapter(data:List<Shop.ShoppInfoBean>):BaseQuickAdapter<Shop.ShoppInfoBean,BaseViewHolder>(R.layout.item_shoppingadapter,data) {
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
    override fun convert(helper: BaseViewHolder?, item: Shop.ShoppInfoBean?) {
        helper?.setText(R.id.tv_goodsName, item?.goods_name)
        helper?.setText(R.id.tv_goodsNum, item?.goods_sn)
        helper?.setText(R.id.tv_goodsPrice, "￥"+item?.goods_price)
        helper?.getView<ImageView>(R.id.iv_goodsImage)?.loadImag(item?.goods_img!!)
        if (indexs==1){
            helper?.getView<SlidingPaneLayout>(R.id.slide)?.openPane()
        }else{
            helper?.getView<SlidingPaneLayout>(R.id.slide)?.closePane()
        }
        helper?.addOnClickListener(R.id.ll_type)
        helper?.addOnClickListener(R.id.ll_content)


    }
}