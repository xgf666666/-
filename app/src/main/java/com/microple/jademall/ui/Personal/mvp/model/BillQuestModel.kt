package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.PointDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.BillQuestContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class BillQuestModel: BillQuestContract.Model {
    override fun getPoint(token: String): Observable<BaseResponseEntity<PointDetail>> =AppApi.Api().getPointDetail(token)
}