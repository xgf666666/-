package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.AboutMe
import com.microple.jademall.bean.Pay
import com.microple.jademall.bean.PayTyle
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface OtherPayContract {
    interface View :BaseMvpView{
        fun otherPay(pay:Pay)
        fun getPayTyle(payTyle: PayTyle)
        fun refecePay(msg: String)
    }
    interface Model{
        fun otherPay(token:String,pay_type:String,sb_id:String,send:String,live:String,cabinet:String,freight_pay:String,incr_type1:String,incr_type2:String,incr_type3:String,address_id:String,userId:String,trade_password:String,msg_id:String):Observable<BaseResponseEntity<Pay>>
        fun getPayTyle(token: String,type:String):Observable<BaseResponseEntity<PayTyle>>
        fun refecePay(token:String,msg_id:String): Observable<BaseResponseEntity<Any>>
    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun otherPay(token:String,pay_type:String,sb_id:String,send:String,live:String,cabinet:String,freight_pay:String,incr_type1:String,incr_type2:String,incr_type3:String,address_id:String,userId:String,trade_password:String,msg_id:String )
        abstract fun getPayTyle(token: String,type:String)
        abstract fun refecePay(token: String,msg_id:String)
    }
}