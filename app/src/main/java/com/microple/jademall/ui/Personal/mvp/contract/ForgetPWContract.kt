package com.microple.jademall.ui.Personal.mvp.contract

import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ForgetPWContract {
    interface View :BaseMvpView{
        fun setPW()
        fun getCode()

    }
    interface Model{
        fun setPW(phone:String,phoneCode:String,PW:String):Observable<BaseResponseEntity<Any>>
        fun getCode(phone: String): Observable<BaseResponseEntity<Any>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun setPW(phone:String,phoneCode:String,PW:String)
        abstract fun getCode(phone: String)

    }
}