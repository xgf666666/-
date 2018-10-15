package com.microple.jademall.ui.live.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
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
class LiveReviewAdapter(layoutId: Int) : BaseQuickAdapter<LiveList.ReplayListBean, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: LiveList.ReplayListBean) {
        helper.setText(R.id.tv_liveName,item.video_name)
        helper.setText(R.id.tv_liveMessage,item.desc)
        helper.setText(R.id.tv_liveTime,item.start_time+"~"+item.end_time)
        helper.getView<ImageView>(R.id.iv_live).loadImag(item.cover_img)
    }

}