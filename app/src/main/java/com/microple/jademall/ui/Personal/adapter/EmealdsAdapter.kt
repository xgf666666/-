package com.microple.jademall.ui.Personal.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Emeralds
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag
import com.xx.baseutilslibrary.network.retrofit.Retrofit2Manager

/**
 * author: xiaoguagnfei
 * date: 2018/8/15
 * describe:
 */
class EmealdsAdapter(data:List<Emeralds.GoodsInfoBean>):BaseQuickAdapter<Emeralds.GoodsInfoBean,BaseViewHolder>(R.layout.item_emeralds,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder, item: Emeralds.GoodsInfoBean) {
        helper.setText(R.id.tv_goodsName,item?.goods_sn)
        helper.getView<ImageView>(R.id.iv_head).loadImag(item.goods_img)
    }
}