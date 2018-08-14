package com.microple.jademall.ui.live.activity

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.microple.jademall.R
import com.microple.jademall.common.Constant
import com.xx.baseuilibrary.mvp.BaseMvpViewActivity
import kotlinx.android.synthetic.main.activity_live_details.*

/**
 * author: linfeng
 * date: 2018/8/6.
 * describe:直播详情
 */
class LiveDetailsActivity : BaseMvpViewActivity() {

    override fun getActivityLayoutId(): Int = R.layout.activity_live_details

    override fun init() {
        title = "直播详情"
        Glide.with(this).load(Constant.item)
                .apply(RequestOptions()
                        .placeholder(R.drawable.ic_img_default)
                        .error(R.drawable.ic_img_default))
                .into(iv_live)
        tv_liveName.text = "JV2367号切石直播"
        tv_liveTime.text = "2018-11-23 12:20"
        tv_liveMessage.text = "J如果你无法简洁的表达你的想法，那只说明你还不够了解它。\n" + " -- 阿尔伯特·爱因斯坦"
    }
}