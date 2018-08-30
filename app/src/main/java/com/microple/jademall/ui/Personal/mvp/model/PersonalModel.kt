package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.PersonInfo
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.PersonalContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class PersonalModel: PersonalContract.Model {
    override fun getInfo(token: String): Observable<BaseResponseEntity<PersonInfo>> =AppApi.Api().personInfo(token)
}