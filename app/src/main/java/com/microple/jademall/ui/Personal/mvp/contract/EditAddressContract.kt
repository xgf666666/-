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
interface EditAddressContract {
    interface View :BaseMvpView{
        fun setEditSuccssful(msg:String)

    }
    interface Model{
        fun addEdit(token:String,receiver:String,phone:String,address:String): Observable<BaseResponseEntity<Any>>
        fun setEdit(token:String,id:String,receiver:String,phone:String,address:String): Observable<BaseResponseEntity<Any>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun addEdit(token:String,receiver:String,phone:String,address:String)
        abstract fun setEdit(token:String,id:String,receiver:String,phone:String,address:String)

    }
}