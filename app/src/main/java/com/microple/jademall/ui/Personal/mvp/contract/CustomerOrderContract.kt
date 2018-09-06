package com.microple.jademall.ui.Personal.mvp.contract

import com.microple.jademall.bean.Customer
import com.xx.baseuilibrary.mvp.BaseMvpPresenter
import com.xx.baseuilibrary.mvp.BaseMvpView
import com.xx.baseutilslibrary.network.entity.BaseResponseEntity
import io.reactivex.Observable

/**
 * author: xiaoguagnfei
 * date: 2018/8/24
 * describe:
 */
interface CustomerOrderContract {
    interface View :BaseMvpView{
        fun getCustomer(customer:Customer)

    }
    interface Model{
        fun getCustomer(token:String): Observable<BaseResponseEntity<Customer>>

    }
    abstract class Presenter:BaseMvpPresenter<Model, View>(){
        abstract fun getCustomer(token: String)

    }
}