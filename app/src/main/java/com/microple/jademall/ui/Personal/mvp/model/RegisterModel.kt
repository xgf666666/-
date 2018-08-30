package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.RegisterContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class RegisterModel: RegisterContract.Model {
    override fun getCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)

    override fun register(phone: String, phone_code: String, pwd: String, pwds: String, code: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().register(phone,phone_code,pwd,pwds,code)
}