package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Login
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface LoginContract {
    interface View :BaseMvpView{
        fun loginSucceful(login:Login)
        fun getCode()
        fun threeFaid()

    }
    interface Model{
        fun pwLogin(phone:String,password:String):Observable<BaseResponseEntity<Login>>
        fun codeLogin(phone:String,phone_code:String):Observable<BaseResponseEntity<Login>>
        fun getCode(phone:String): Observable<BaseResponseEntity<Any>>
        fun threeLogin(openid:String):Observable<BaseResponseEntity<Login>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun pwLogin(phone:String,password:String)
        abstract fun codeLogin(phone:String,phone_code:String)
        abstract fun getCode(phone:String)
        abstract fun threeLogin(openid:String)

    }
}