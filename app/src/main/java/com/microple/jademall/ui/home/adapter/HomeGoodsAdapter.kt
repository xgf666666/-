package com.microple.jademall.ui.home.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Goods
import com.microple.jademall.common.Constant

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeGoodsAdapter(data:List<Goods.GoodsListBean>) : BaseQuickAdapter<Goods.GoodsListBean, BaseViewHolder>(R.layout.item_goods,data) {

    override fun convert(helper: BaseViewHolder, item: Goods.GoodsListBean) {
        helper.setText(R.id.tv_goodsName, item.goods_name)
        helper.setText(R.id.tv_goodsNum, item.goods_sn)
        helper.setText(R.id.tv_goodsPrice, "￥"+item.goods_price)
        Glide.with(mContext).load(item.goods_img)
                .apply(RequestOptions()
                        .placeholder(R.drawable.ic_img_default)
                        .error(R.drawable.ic_img_default))
                .into(helper.getView(R.id.iv_goodsImage) as ImageView)
    }
}