package com.microple.jademall.ui.search.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.bean.SearchResult

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:
 */
class SeacrhLiveAdapter : BaseQuickAdapter<SearchResult.LiveListBean, BaseViewHolder>(R.layout.item_live_recommend) {
    override fun convert(helper: BaseViewHolder, item: SearchResult.LiveListBean) {
        helper.setText(R.id.tv_liveName,item.live_title)
        helper.setText(R.id.tv_liveMessage,item.desc)
        helper.setText(R.id.tv_liveTime,item.live_time)
    }

}