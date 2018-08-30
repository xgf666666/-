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
interface PassWorkContract {
    interface View :BaseMvpView{
        fun setSucceful()
        fun getCode()

    }
    interface Model{
        fun setCode(phone:String):Observable<BaseResponseEntity<Any>>
        fun setPW(token:String,phone_code:String,password:String): Observable<BaseResponseEntity<Any>>
        fun setPayPW(token:String,phone_code:String,password:String):Observable<BaseResponseEntity<Any>>
        fun setPhone(token:String,phone_code:String,phone:String):Observable<BaseResponseEntity<Any>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract  fun setPW(token:String,phone_code:String,password:String)
        abstract  fun setPayPW(token:String,phone_code:String,password:String)
        abstract fun setPhone(token:String,phone_code:String,phone:String)
        abstract fun setCode(phone:String)
    }
}