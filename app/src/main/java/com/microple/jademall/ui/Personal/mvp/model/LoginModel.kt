package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.LoginContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class LoginModel: LoginContract.Model {
    override fun pwLogin(phone: String, password: String) =AppApi.Api().pwLogin(phone,password)
    override fun getCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)
    override fun codeLogin(phone: String, phone_code: String) =AppApi.Api().codeLogin(phone,phone_code)

}