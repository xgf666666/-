package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.EmeraldsDetail
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface EmeraldsDetailContract {
    interface View :BaseMvpView{
        fun  getEmeraldsDetail(emeraldsDetail: EmeraldsDetail)
        fun exchange()

    }
    interface Model{
        fun getEmeraldsDetail(token:String,ct_id:String): Observable<BaseResponseEntity<EmeraldsDetail>>
        fun exchange(token:String,ct_id:String):Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getEmeraldsDetail(token: String,ct_id:String)
        abstract fun exchange(token: String,ct_id:String)

    }
}