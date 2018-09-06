package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Order
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface AllOrderContract {
    interface View :BaseMvpView{
       fun getOrder(order:Order)

    }
    interface Model{
        fun getOrder(token:String,order_status:String): Observable<BaseResponseEntity<Order>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getOrder(token:String,order_status:String)
    }
}