package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.CustiomerDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface CusetomerOrderDetailContract {
    interface View :BaseMvpView{
        fun getDetail(custiomerDetail: CustiomerDetail)
        fun sendBack()

    }
    interface Model{
        fun getDetail(token:String,as_id:String): Observable<BaseResponseEntity<CustiomerDetail>>
        fun sendBack(token:String,as_id:String,shipping_name:String,shipping_code:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getDetail(token:String,as_id:String)
        abstract fun sendBack(token:String,as_id:String,shipping_name:String,shipping_code:String)

    }
}