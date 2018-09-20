package com.microple.jademall.ui.live.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.LiveGoods
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:
 */
class LiveGoodsAdapter (layoutId: Int) : BaseQuickAdapter<LiveGoods.GoodsBean, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: LiveGoods.GoodsBean) {
        helper.setText(R.id.tv_goodsName, item.goods_name)
        helper.setText(R.id.tv_goodsNum, item.goods_sn)
        helper.setText(R.id.tv_goodsPrice, "￥ "+item.goods_price)
        helper?.getView<ImageView>(R.id.iv_goodsImage).loadImag(item.goods_img)
    }
}