package com.microple.jademall.ui.live.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.LiveList
import com.microple.jademall.common.Constant

/**
 * author: linfeng
 * date: 2018/8/7.
 * describe:
 */
class LiveYuyueAdapter  : BaseQuickAdapter<LiveList.AppointLiveBean, BaseViewHolder>(R.layout.item_yuyue_live) {
    override fun convert(helper: BaseViewHolder, item: LiveList.AppointLiveBean) {
        helper?.setText(R.id.tv_title,item.message)
    }
}