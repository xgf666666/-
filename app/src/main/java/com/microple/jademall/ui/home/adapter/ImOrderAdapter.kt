package com.microple.jademall.ui.home.adapter

import android.support.v4.widget.SlidingPaneLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.common.Constant

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class ImOrderAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_imadapter,data) {
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
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.tv_goodsName, "糯冰种飘翠福瓜挂件")
        helper?.setText(R.id.tv_goodsNum, "ACS322332")
        helper?.setText(R.id.tv_goodsPrice, "￥3980.00")
        Glide.with(mContext).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.drawable.ic_img_default)
                        .error(R.drawable.ic_img_default))
                .into(helper?.getView(R.id.iv_goodsImage) as ImageView)
        if (indexs==1){
            helper?.getView<SlidingPaneLayout>(R.id.slide).openPane()
        }else{
            helper?.getView<SlidingPaneLayout>(R.id.slide).closePane()
        }
        helper?.addOnClickListener(R.id.ll_type)

    }
}