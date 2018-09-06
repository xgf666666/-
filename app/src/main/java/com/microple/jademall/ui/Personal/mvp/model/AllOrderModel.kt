package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Order
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AllOrderContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class AllOrderModel: AllOrderContract.Model {
    override fun getOrder(token: String, order_status: String): Observable<BaseResponseEntity<Order>> =AppApi.Api().getOrder(token,order_status)
}