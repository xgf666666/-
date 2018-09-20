package com.microple.jademall.ui.live.mvp.model

import com.microple.jademall.bean.LiveDetail
import com.microple.jademall.bean.LiveShare
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.microple.jademall.ui.live.mvp.contract.LivePlayerContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LivePlayerModel: LivePlayerContract.Model {
    override fun liveShare(live_id: String): Observable<BaseResponseEntity<LiveShare>> =AppApi.Api().liveShare(live_id)


}