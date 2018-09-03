package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.MyMessage
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface MessageContract {
    interface View :BaseMvpView{
        fun getMessage(myMessage: MyMessage)

    }
    interface Model{
        fun getMessage(token:String): Observable<BaseResponseEntity<MyMessage>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getMessage(token:String)

    }
}