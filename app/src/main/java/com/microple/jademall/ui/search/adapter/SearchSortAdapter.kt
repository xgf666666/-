package com.microple.jademall.ui.search.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.Search
import com.microple.jademall.common.Constant

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:二级类别
 */
class SearchSortAdapter (layoutId: Int) : BaseQuickAdapter<Search.CategorysBean, BaseViewHolder>(layoutId){
    override fun convert(helper: BaseViewHolder, item: Search.CategorysBean) {
        helper.setText(R.id.tv_sort,item.name)
    }
}