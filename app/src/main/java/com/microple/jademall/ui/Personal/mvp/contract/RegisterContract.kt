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
interface RegisterContract {
    interface View :BaseMvpView{
        fun getCode(code:String)
        fun register()


    }
    interface Model{
        fun getCode(phone:String): Observable<BaseResponseEntity<Any>>
        fun register(phone:String,phone_code:String,pwd:String,pwds:String,code:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getCode(phone: String)
        abstract fun register(phone:String,phone_code:String,pwd:String,pwds:String,code:String)


    }
}