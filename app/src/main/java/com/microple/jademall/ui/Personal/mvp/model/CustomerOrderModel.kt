package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Customer
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.CustomerOrderContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerOrderModel: CustomerOrderContract.Model {
    override fun getCustomer(token: String): Observable<BaseResponseEntity<Customer>> =AppApi.Api().getCustomer(token)
}