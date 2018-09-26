package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.ServicePhone
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.CustomerServiceContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class CustomerServiceModel: CustomerServiceContract.Model {
    override fun getPhone(): Observable<BaseResponseEntity<ServicePhone>> =AppApi.Api().phone

}