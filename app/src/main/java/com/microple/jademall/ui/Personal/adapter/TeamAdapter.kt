package com.microple.jademall.ui.Personal.adapter

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
class TeamAdapter(data:List<String>):BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_team,data) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.setText(R.id.tv_name,"糯冰件")
        helper?.setText(R.id.tv_phone,"12456893")
        helper?.setText(R.id.tv_Price,"产生佣金 153266")
        Glide.with(mContext).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.drawable.ic_img_default)
                        .error(R.drawable.ic_img_default))
                .into(helper?.getView(R.id.iv_goodsImage) as ImageView )
    }
}