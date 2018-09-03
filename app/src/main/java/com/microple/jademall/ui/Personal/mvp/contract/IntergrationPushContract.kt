package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AccountIinfo
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

    }
    interface Model{
        fun getAccout(token:String): Observable<BaseResponseEntity<AccountIinfo>>
        fun push(token: String,to_user:String,points:String):Observable<BaseResponseEntity<Any>>


    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getAccout(token:String)
        abstract fun push(token: String,to_user:String,points:String)
    }
}