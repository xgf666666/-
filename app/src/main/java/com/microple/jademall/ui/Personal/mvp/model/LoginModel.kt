package com.microple.jademall.ui.Personal.mvp.model


import com.microple.jademall.bean.Login
import com.microple.jademall.bean.PersonInfo
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
    override fun threeLogin(openid: String): Observable<BaseResponseEntity<Login>> =AppApi.Api().threeLogin(openid)

    override fun pwLogin(phone: String, password: String) =AppApi.Api().pwLogin(phone,password)
    override fun getCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)
    override fun codeLogin(phone: String, phone_code: String) =AppApi.Api().codeLogin(phone,phone_code)
    override fun getInfo(token: String): Observable<BaseResponseEntity<PersonInfo>> =AppApi.Api().personInfo(token)

}