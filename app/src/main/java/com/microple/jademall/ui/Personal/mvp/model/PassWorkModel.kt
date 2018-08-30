package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.PassWorkContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PassWorkModel: PassWorkContract.Model {
    override fun setCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)

    override fun setPayPW(token: String, phone_code: String, password: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().setPayPW(token,phone_code,password)

    override fun setPW(token: String, phone_code: String, password: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().setPW(token,phone_code,password)
    override fun setPhone(token: String, phone_code: String, phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().setPhone(token,phone_code,phone)
}