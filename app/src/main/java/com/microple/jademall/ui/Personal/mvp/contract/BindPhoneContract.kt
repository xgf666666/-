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
interface BindPhoneContract {
    interface View :BaseMvpView{
        fun bindPhone(login:Login)
        fun getCode()

    }
    interface Model{
        fun bindPhone(openid:String,phone:String,phone_code:String,code:String,nickname	:String,head_img:String): Observable<BaseResponseEntity<Login>>
        fun getCode(phone:String):Observable<BaseResponseEntity<Any>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun bindPhone(openid:String,phone:String,phone_code:String,code:String,nickname:String,head_img:String)
        abstract fun getCode(phone:String)

    }
}