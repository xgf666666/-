package com.microple.jademall.ui.live.adapter

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.microple.jademall.R
import com.microple.jademall.common.Constant

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:
 */
class LiveReviewAdapter(layoutId: Int) : BaseQuickAdapter<Any, BaseViewHolder>(layoutId) {
    override fun convert(helper: BaseViewHolder, item: Any) {
        Glide.with(mContext).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.mipmap.ic_img_default)
                        .error(R.mipmap.ic_img_default))
                .into(helper.getView(R.id.iv_live) as ImageView)
        helper.setText(R.id.tv_liveName,"JV2367号切石直播")
        helper.setText(R.id.tv_liveMessage,"如果你无法简洁的表达你的想法，那只说明你还不够了解它。")
        helper.setText(R.id.tv_liveTime,"2018-11-23 12:11 ~ 12:20")
    }

}