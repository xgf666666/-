package com.microple.jademall.ui.Personal.mvp.model

import com.microple.jademall.bean.MyAppointment
import com.microple.jademall.common.AppApi
import com.microple.jademall.ui.Personal.mvp.contract.AboutMeContract
import com.microple.jademall.ui.Personal.mvp.contract.MyAppointmentContract
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable


/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
class MyAppointmentModel: MyAppointmentContract.Model {
    override fun exitAppoint(token: String, live_id: String): Observable<BaseResponseEntity<List<Any>>> =AppApi.Api().exitAppointment(token,live_id)

    override fun myAppoint(token: String): Observable<BaseResponseEntity<MyAppointment>> =AppApi.Api().myAppointment(token)
}