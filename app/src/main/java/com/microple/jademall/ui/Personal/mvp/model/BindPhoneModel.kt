package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.Login
import com.microple.jademall.bean.PersonInfo
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.BindPhoneContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class BindPhoneModel: BindPhoneContract.Model {
    override fun getCode(phone: String): Observable<BaseResponseEntity<Any>> =AppApi.Api().getCode(phone)

    override fun bindPhone(openid: String, phone: String, phone_code: String, code: String,nickname	:String,head_img:String,is_bind:String): Observable<BaseResponseEntity<Login>> =
            AppApi.Api().bindPhone(openid,phone,phone_code,code,nickname,head_img,is_bind)
    override fun getInfo(token: String): Observable<BaseResponseEntity<PersonInfo>> =AppApi.Api().personInfo(token)


}
