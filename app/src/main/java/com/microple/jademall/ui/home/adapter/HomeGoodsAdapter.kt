package com.microple.jademall.ui.home.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Goods
import com.microple.jademall.uitls.loadImag

/**
 * author: linfeng
 * date: 2018/8/3.
 * describe:
 */
class HomeGoodsAdapter(data: List<Goods.GoodsListBean>) : BaseQuickAdapter<Goods.GoodsListBean, BaseViewHolder>(R.layout.item_goods, data) {

    override fun convert(helper: BaseViewHolder, item: Goods.GoodsListBean) {
        helper.setText(R.id.tv_goodsName, item.goods_name)
        helper.setText(R.id.tv_goodsNum, item.goods_sn)
        helper.setText(R.id.tv_goodsPrice, "￥" + item.goods_price)
        helper?.getView<ImageView>(R.id.iv_goodsImage).loadImag(item.goods_img)
    }
}