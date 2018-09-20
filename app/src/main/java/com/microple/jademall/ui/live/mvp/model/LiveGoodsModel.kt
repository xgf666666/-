package com.microple.jademall.ui.live.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.microple.jademall.ui.live.mvp.contract.LiveGoodsContract


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveGoodsModel: LiveGoodsContract.Model {
    override fun getGoods(live_id: String) =AppApi.Api().liveGoods(live_id)
}