package com.microple.jademall.ui.live.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.LiveList

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:
 */
class LiveRecommendAdapter(layoutId: Int) : BaseQuickAdapter<LiveList.RecoLiveBean, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: LiveList.RecoLiveBean) {
        helper.setText(R.id.tv_liveName,item.live_title)
        helper.setText(R.id.tv_liveMessage,item.desc)
        helper.setText(R.id.tv_liveTime,item.live_time+"~"+item.end_time)
    }

}