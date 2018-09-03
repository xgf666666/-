package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.ForgetPWContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class ForgetPWModel: ForgetPWContract.Model {
    override fun setPW(phone: String, phoneCode: String, PW: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().forgetPW(phone,phoneCode,PW)

    override fun getCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)
}