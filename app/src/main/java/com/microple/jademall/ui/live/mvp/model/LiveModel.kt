package com.microple.jademall.ui.live.mvp.model

import com.microple.jademall.bean.LiveList
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.live.mvp.contract.LiveContract
import com.microple.jademall.ui.live.mvp.contract.LiveDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LiveModel: LiveContract.Model {
    override fun liveList(token: String): Observable<BaseResponseEntity<LiveList>> =AppApi.Api().liveList(token)
}