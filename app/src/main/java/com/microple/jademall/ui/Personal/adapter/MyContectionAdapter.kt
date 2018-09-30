package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Collection
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class MyContectionAdapter(data:List<Collection.ListBean>):BaseQuickAdapter<Collection.ListBean,BaseViewHolder>(R.layout.item_mycontection) {
    override fun convert(helper: BaseViewHolder?, item: Collection.ListBean?) {
        helper?.setText(R.id.tv_goodsName, item?.goods_name)
        helper?.setText(R.id.tv_goodsNum, item?.goods_sn)
        helper?.setText(R.id.tv_goodsPrice, "￥"+item?.goods_price)
        helper?.getView<ImageView>(R.id.iv_goodsImage)?.loadImag(item?.goods_img!!)
    }
}