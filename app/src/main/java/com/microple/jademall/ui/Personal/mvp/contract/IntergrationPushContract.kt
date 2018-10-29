package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AccountIinfo
import com.microple.jademall.bean.UserInfo
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface IntergrationPushContract {
    interface View :BaseMvpView{
        fun getAccout(accoutInfo:AccountIinfo)
        fun push()
        fun pushInfo(userInfo: UserInfo)

    }
    interface Model{
        fun getAccout(token:String): Observable<BaseResponseEntity<AccountIinfo>>
        fun push(token: String,to_user:String,points:String,frozen_points:String,trade_password:String):Observable<BaseResponseEntity<Any>>
        fun pushInfo(token: String,phone:String): Observable<BaseResponseEntity<UserInfo>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getAccout(token:String)
        abstract fun push(token: String,to_user:String,points:String,frozen_points:String,trade_password:String)
        abstract fun pushInfo(token: String,phone:String)
    }
}