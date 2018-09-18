package com.microple.jademall.ui.home.mvp.contract

import com.microple.jademall.bean.ImOrder
import com.microple.jademall.bean.Pay
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface ImOrderContract {
    interface View :BaseMvpView{
        fun imOrder(imOrder:ImOrder)
        fun pay(pay:Pay)

    }
    interface Model{
        fun imOrder(token:String,sb_id:String,goods_id:String): Observable<BaseResponseEntity<ImOrder>>
        fun pay(token:String,send:String,live:String,cabinet:String,address_id:String,pay_type:String,trade_password:String):Observable<BaseResponseEntity<Pay>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
       abstract fun imOrder(token:String,sb_id:String,goods_id:String)
        abstract fun pay(token:String,send:String,live:String,cabinet:String,address_id:String,pay_type:String,trade_password:String)

    }
}