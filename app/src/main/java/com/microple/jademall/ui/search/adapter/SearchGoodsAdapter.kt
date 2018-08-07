package com.microple.jademall.ui.search.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.base.Constant

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class SearchGoodsAdapter(layoutId: Int) : BaseQuickAdapter<Any, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: Any) {
        helper.setText(R.id.tv_goodsName, "糯冰种飘翠福瓜挂件")
        helper.setText(R.id.tv_goodsNum, "ACS322332")
        helper.setText(R.id.tv_goodsPrice, "￥3980.00")
        Glide.with(mContext).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.mipmap.ic_img_default)
                        .error(R.mipmap.ic_img_default))
                .into(helper.getView(R.id.iv_goodsImage) as ImageView)
    }
}