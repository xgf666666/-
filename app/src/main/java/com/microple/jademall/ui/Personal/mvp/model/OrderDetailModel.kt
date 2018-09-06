package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.OrderDetail
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.OrderDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class OrderDetailModel: OrderDetailContract.Model {
    override fun sureOrder(token: String, order_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().sureDetail(token,order_id)

    override fun exitOrder(token: String, order_id: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().exitDetail(token,order_id)

    override fun getDetail(token: String, order_id: String): Observable<BaseResponseEntity<OrderDetail>> = AppApi.Api().getOrderDetail(token,order_id)
}