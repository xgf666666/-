package com.microple.jademall.ui.live.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.LiveList
import com.microple.jademall.common.Constant
import com.microple.jademall.uitls.loadImag

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:
 */
class LiveHotAdapter(layoutId: Int) : BaseQuickAdapter<LiveList.LiveNowBean, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: LiveList.LiveNowBean) {
        helper.setText(R.id.tv_liveName,item.live_title)
        helper.setText(R.id.tv_liveMessage,item.desc)
        helper.setText(R.id.tv_liveTime,item.live_time+"~"+item.end_time)
        helper.getView<ImageView>(R.id.iv_live).loadImag(item.cover_img)
    }

}