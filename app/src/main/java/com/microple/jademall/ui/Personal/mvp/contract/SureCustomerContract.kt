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
interface SureCustomerContract {
    interface View :BaseMvpView{
        fun apply()

    }
    interface Model{
        fun apply(token:String,order_id:String,goods_id:String,reason:String,desc:String,refunds:String): Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun apply(token:String,order_id:String,goods_id:String,reason:String,desc:String,refunds:String)
    }
}