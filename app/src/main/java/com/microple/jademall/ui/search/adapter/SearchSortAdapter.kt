package com.microple.jademall.ui.search.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.common.Constant

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:二级类别
 */
class SearchSortAdapter (layoutId: Int) : BaseQuickAdapter<Any, BaseViewHolder>(layoutId){
    override fun convert(helper: BaseViewHolder, item: Any) {
        Glide.with(mContext).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.drawable.ic_img_default)
                        .error(R.drawable.ic_img_default))
                .into(helper.getView(R.id.iv_sort) as ImageView)
        helper.setText(R.id.tv_sort,"翡翠类别")
    }
}