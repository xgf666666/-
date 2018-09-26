package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.MyAppointment
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MyAppointmentContract {
    interface View :BaseMvpView{
        fun myAppoint(myAppointment: MyAppointment)
        fun exitAppoint(msg:String)

    }
    interface Model{
        fun myAppoint(token:String): Observable<BaseResponseEntity<MyAppointment>>
        fun exitAppoint(token: String,live_id:String):Observable<BaseResponseEntity<List<Any>>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun myAppoint(token: String)
        abstract fun exitAppoint(token: String,live_id:String)
    }
}