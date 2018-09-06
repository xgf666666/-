package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.CusetomerOrderDetailContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderDetailModel: CusetomerOrderDetailContract.Model {
    override fun sendBack(token: String, as_id: String, shipping_name: String, shipping_code: String): Observable<BaseResponseEntity<Any>> =
            AppApi.Api().sendBack(token,as_id,shipping_name,shipping_code)

    override fun getDetail(token: String, as_id: String) =AppApi.Api().customerDetail(token,as_id)
}