package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.OrderDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface OrderDetailContract {
    interface View :BaseMvpView{
        fun getDetail(orderDetail: OrderDetail)
        fun sureOrder()
        fun exitOrder()

    }
    interface Model{
        fun getDetail(token:String,order_id:String): Observable<BaseResponseEntity<OrderDetail>>
        fun sureOrder(token: String,order_id:String):Observable<BaseResponseEntity<Any>>
        fun exitOrder(token: String,order_id:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(token: String,order_id:String)
        abstract  fun sureOrder(token: String,order_id:String)
        abstract fun exitOrder(token: String,order_id:String)

    }
}