package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.SureCustomerContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class SureCustomerModel: SureCustomerContract.Model {
    override fun apply(token: String, order_id: String, goods_id: String, reason: String, desc: String, refunds: String): Observable<BaseResponseEntity<Any>> =
            AppApi.Api().ApplyCus(token,order_id,goods_id,reason,desc,refunds)
}